<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <BookingConfirmationTemplate :title="title" :roomObject="room"/>
    </ion-content>
  </ion-page>
</template>

<script>
import BookingConfirmationTemplate from '@/components/BookingConfirmationTemplate.vue';
import {useRoomsStore} from "@/stores/room";
import { useRoute } from 'vue-router';
import { watch } from 'vue';

export default {
  name: 'BookingConfirmationPage',
  components: {
    BookingConfirmationTemplate
  },
  setup(){
    const route = useRoute();

    const roomId = route.query.id;
    const start = route.query.start;
    const end = route.query.end;
    const title = route.query.title;
    watch(() => route.path, () => {});

    return {
        start,
        end,
        title,
        roomId
      }
  },
  data: () => {
    return{
      roomStore: useRoomsStore(),
      room: {},
    }
  },
  async mounted() {
    await this.getRoom()
  },
  methods: {
    async getRoom() {
      console.log("fetch room");
      this.room = await this.roomStore.fetchRoomById(this.roomId);
      console.log(room)
    },
  },
};
</script>