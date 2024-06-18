<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <BookingConfirmationTemplate />
    </ion-content>
  </ion-page>
</template>

<script>
import BookingConfirmationTemplate from '@/components/BookingConfirmationTemplate.vue';
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
  }
};
</script>