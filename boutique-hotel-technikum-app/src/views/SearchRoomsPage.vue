<script setup lang="ts">
import SearchRoomsTemplate from "@/components/SearchRoomsTemplate.vue";
import { useRoute } from 'vue-router';
import { watch } from 'vue';

const route = useRoute();

const start = route.query.start;
const end = route.query.end;
watch(() => route.path, () => {
  // Reset your component's state here
});

</script>


<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <SearchRoomsTemplate :start="start" :end="end"></SearchRoomsTemplate>
    </ion-content>
  </ion-page>
</template>

<style scoped>

</style>