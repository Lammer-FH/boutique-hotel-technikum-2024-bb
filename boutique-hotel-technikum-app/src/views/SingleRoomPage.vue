<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content >
      <SingleRoomTemplate :roomId="id" :startDate="startDate" :endDate="endDate"/>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import SingleRoomTemplate from "@/components/SingleRoomTemplate.vue";
import { useRoute } from 'vue-router';
import { watch } from 'vue';

const route = useRoute();

const id = route.query.id;
const startDate = route.query.start;
const endDate = route.query.end;
watch(() => route.path, () => {});

</script>

<style scoped>

</style>