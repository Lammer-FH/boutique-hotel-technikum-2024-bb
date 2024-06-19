<template>
  <ion-page>

    <RoomDetailsCard v-if="roomObject.length > 0" :room="roomObject[0]" :start="startDate" :end="endDate" />
    room id: {{ roomId}}
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
    }
  },
  props: ['roomId', 'startDate', 'endDate'],
  async mounted() {
    if (this.roomId) {
      console.log(`Attempting to fetch details for room ID: ${this.roomId}`);
      await this.fetchRoomById(this.roomId);
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
      if (this.roomObject.length > 0) {
        this.roomObject.splice(0);
      }
      this.roomObject.push(await this.roomStore.fetchRoomById(roomId));
    },
  }
}
</script>

<style scoped>

</style>