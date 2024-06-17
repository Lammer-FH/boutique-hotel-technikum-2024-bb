<script setup lang="ts">
import { ref } from 'vue';
import SearchForRoomsCard from "@/components/SearchForRoomsCard.vue";
import FooterSegment from '@/components/organisms/FooterSegement.vue';

const showMoreText = ref(false);

const toggleMoreText = () => {
  showMoreText.value = !showMoreText.value;
};
</script>

<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Welcome to Boutique-Technikum</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <SearchForRoomsCard></SearchForRoomsCard>
      <ion-card>
        <img src="" alt="Descriptive Text of Image">
        <ion-card-content>
          Description or additional content related to the image.
        </ion-card-content>
      </ion-card>
      <ion-card>
        <ion-card-content>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore...
          <ion-button fill="clear" @click="toggleMoreText">Read More</ion-button>
          <p v-show="showMoreText">
            Additional details here. Continue the description of the text, providing more in-depth information. This area can be used to extend any type of content or information you wish to remain initially hidden.
          </p>
        </ion-card-content>
      </ion-card>
      <FooterSegment></FooterSegment>
    </ion-content>
  </ion-page>
</template>

<style scoped>

</style>