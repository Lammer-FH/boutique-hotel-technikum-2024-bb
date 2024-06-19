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
import {useRoute, useRouter} from 'vue-router';
import { watch } from 'vue';


export default {
  name: 'BookingConfirmationPage',
  components: {
    BookingConfirmationTemplate
  },
  setup() {
    const router = useRouter();
    const route = useRoute();

    const roomId = route.query.id;
    const startDate = route.query.start;
    const endDate = route.query.end;
    watch(() => route.path, () => {});

    async function routeToConfimationpage() {
      await router.push({ name: 'Booking Confirmation', query: { id: roomId, start: startDate, end: endDate} });
    }

    return {
      routeToConfimationpage,
      roomId,
      startDate,
      endDate
    }
  },
  data: () => {
    return{
      roomStore: useRoomsStore(),
      room: {}
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