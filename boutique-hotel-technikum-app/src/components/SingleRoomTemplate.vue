<template>
  <ion-page>
    <RoomDetailsCard v-if="roomObject.length > 0" :room="roomObject[0]" :start="startDate" :end="endDate" />
  </ion-page>
</template>

<script lang="ts">
import RoomDetailsCard from "@/components/organisms/RoomDetailsCard.vue";
import {useRoomsStore} from "@/stores/room";
import {ref} from "vue";

export default {
  components: {RoomDetailsCard},
  data() {
    return {
      roomStore: useRoomsStore(),
      roomObject: ref<any[]>([]),
      startDate: this.start,
      endDate: this.end
    }
  },
  props: {
    roomId: Number,
    start: String,
    end: String
  },
  mounted() {
    if (this.roomId) {
      console.log(`Attempting to fetch details for room ID: ${this.roomId}`);
      this.fetchRoomById(this.roomId);
    } else {
      console.error("No room ID provided, cannot fetch room details.");
    }
  },
  methods: {
    async fetchRoomById(roomId: number) {
      if (!roomId) {
        console.error("Room ID is required to fetch room details.");
        return;
      }
      console.log(`Fetching room details for ID: ${roomId}`);
      this.roomObject.push(this.roomStore.fetchRoomById(roomId));
    }
  }
}
</script>

<style scoped>

</style>