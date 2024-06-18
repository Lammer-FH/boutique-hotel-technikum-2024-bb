<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <BookingConfirmationTemplate :room="room" />
    </ion-content>
  </ion-page>
</template>

<script>
import BookingConfirmationTemplate from '@/components/BookingConfirmationTemplate.vue';
import {useRoomsStore} from "@/stores/room";
import { useRoute } from 'vue-router';
import { watch } from 'vue';

const route = useRoute();

//const start = route.query.start;
//const end = route.query.end;
//watch(() => route.path, () => {});

export default {
  name: 'BookingConfirmationPage',
  components: {
    BookingConfirmationTemplate
  },
  data: () => {
    return{
      roomStore: useRoomsStore(),
      room: {},
      roomId: 1
    }
  },
  methods: {
    async getRoom() {
      console.log("fetch room");
      await this.roomStore.fetchRoomById(roomId);
      this.room = this.roomStore.room;
      console.log(room)
    },
  },
};
</script>