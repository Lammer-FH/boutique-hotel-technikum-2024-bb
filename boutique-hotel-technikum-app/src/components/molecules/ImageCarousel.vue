<template>
  <ion-card>
      <ImageAtom file-path="./images/welcomePage/Eingang.jpg"></ImageAtom>

      <ion-card-content>
          <p class="description">Nestled in the heart of our vibrant city, Hotel Technikum offers a perfect blend of modern elegance and warm hospitality. Whether you are here for business or leisure, our hotel provides a tranquil retreat with luxurious amenities and exceptional service.</p>
      </ion-card-content>
  </ion-card>
</template>

<script>
import ImageAtom from "@/components/atoms/Image.vue";
import TextLabel from "@/components/atoms/Label.vue";

export default {
    name: "ImageCarousel",
    components: {TextLabel, ImageAtom}
}
</script>

<style scoped>

.description {
    font-size: 1rem;
    color: #555;
}
</style>
