<template>
  <ion-app>
    <NavigationBar :title="title" />
    <ion-router-outlet />
  </ion-app>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import { IonApp, IonRouterOutlet } from '@ionic/vue';
import { useRoute } from 'vue-router';
import NavigationBar from '@/components/NavigationBar.vue';

const route = useRoute();
const title = computed(() => route.meta.title);
</script>
