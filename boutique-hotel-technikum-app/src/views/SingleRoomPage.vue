<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      id: {{id}}
      from: {{startDate}}
      to: {{endDate}}
      <ion-card>
        <div class="image-container">
          <img src="" alt="Room Image">
        </div>
        <ion-card-content>
          Description or additional content related to the image.
        </ion-card-content>
      </ion-card>
      <ion-card>
        <ion-card-content>
          <ion-card-title>Single Room</ion-card-title>
          <ion-label>
            <strong>DATES</strong><br>
            From: July 06 To: July 07
          </ion-label>
          <ion-label>
            <strong>DETAILS</strong><br>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
          </ion-label>
          <ion-label>
            <strong>EXTRAS</strong><br>
            Breakfast, Free Wifi
          </ion-label>
          <ion-item>
            <ion-label>
              <strong>Nights:</strong> 1<br>
              <strong>Price per night:</strong> 0,00€<br>
              <strong>Total:</strong> 0,00€
            </ion-label>
          </ion-item>
          <ion-button expand="full">Payment Details →</ion-button>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import { watch } from 'vue';

const route = useRoute();

const id = route.query.id;
const startDate = route.query.start;
const endDate = route.query.end;
watch(() => route.path, () => {});

</script>

<style scoped>
.image-container img {
  width: 100%;
  height: auto;
}
</style>