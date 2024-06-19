<script setup lang="ts">
import ImageCarousel from "@/components/molecules/ImageCarousel.vue";
import {IonPage} from "@ionic/vue";
</script>

<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
 <ion-content>
      <h2 class="title">Welcome to Hotel Technikum</h2>
      <ImageCarousel></ImageCarousel>
      <p class="description">
        <b>Modern Elegance:</b> Our contemporary design seamlessly blends sophistication with warmth. From the sleek lobby to the thoughtfully curated rooms, you'll find an ambiance that resonates with both business travelers and leisure seekers.
      </p>
      <p class="description">
        <b>Exceptional Service:</b> Our dedicated staff anticipates your needs, whether it's arranging transportation, recommending local attractions, or ensuring a seamless check-in. We believe that true hospitality lies in the details.
      </p>
      <p class="description">
        <b>Luxurious Amenities:</b> Immerse yourself in comfort. Enjoy plush bedding, spa-inspired bathrooms, and stunning city views. Unwind at our rooftop pool or savor culinary delights at our award-winning restaurant.
      </p>
      <p class="description">
        Whether you're here for a business conference, a romantic getaway, or simply to explore the city, Hotel Technikum is your haven. Welcome home.
      </p>
    </ion-content>
  </ion-page>
</template>

<style scoped>
/* Customize your styles here */
.title {
  font-size: 24px;
  color: #333;
  margin-bottom: 10px;
}

.description {
  font-size: 16px;
  color: #555;
  line-height: 1.5;
}
</style>
