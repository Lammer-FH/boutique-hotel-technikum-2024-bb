<template>
  <BookingConfirmationTemplate :room="room" />
</template>

<script>
import BookingConfirmationTemplate from '@/components/BookingConfirmationTemplate.vue';
import {useRoomsStore} from "@/stores/room";

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