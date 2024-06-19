<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <SingleRoomTemplate :room="roomObject[0]" :startDate="startDate" :endDate="endDate"/>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import SingleRoomTemplate from "@/components/SingleRoomTemplate.vue";
import {useRoomsStore} from "@/stores/room";
import {ref, watch} from "vue";
import { useRoute } from 'vue-router';

export default {
  components: {SingleRoomTemplate},
  data() {
    return {
      roomStore: useRoomsStore(),
      roomObject: ref<any[]>([]),
    }
  },
  setup() {
    const route = useRoute();

    const roomId = route.query.id;
    const startDate = route.query.start;
    const endDate = route.query.end;
    watch(() => route.path, () => {});

    return {
      roomId,
      startDate,
      endDate
    }
  },
  beforeRouteUpdate(to, from, next) {
    // Fetch data based on the new route parameters (e.g., to.params.itemId)
    this.fetchRoomById(to.params.id[0]);
    next();
  },
  async mounted() {
    if (this.roomId) {
      //await this.fetchRoomById(this.roomId[0]);

    } else {
      console.error("No room ID provided, cannot fetch room details.");
    }
  },
  created() {
    const reloaded = localStorage.getItem('reloaded');
    if (reloaded !== 'true') {
      localStorage.setItem('reloaded', 'true');
      location.reload();
    }
  },
  methods: {
    async fetchRoomById(roomId: string) {
      const newRoomId = parseInt(roomId);
      if (!newRoomId) {
        console.error("Room ID is required to fetch room details.");
        return;
      }
      console.log(`Fetching room details for ID: ${newRoomId}`);
      this.roomObject.splice(0);
      console.log("got room fetch " + newRoomId)
      this.roomObject.push(await this.roomStore.fetchRoomById(newRoomId));
    },
  }
}
</script>

<style scoped>

</style>