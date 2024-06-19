<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <BookingConfirmationTemplate :roomId="roomId" :title="title"/>
    </ion-content>
  </ion-page>
</template>

<script>
import BookingConfirmationTemplate from '@/components/BookingConfirmationTemplate.vue';
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

};
</script>