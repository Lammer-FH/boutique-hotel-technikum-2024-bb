<template>
    <header-title title="Welcome to Technikum"></header-title>
    <SearchForRoomsCard @search-for-rooms="searchForRooms" :search-model="searchModel"></SearchForRoomsCard>
    <ion-card>
    <image-carousel></image-carousel>
    </ion-card>

    <span class="text-center">
        <ion-button size="medium" class="text-style" shape="round" v-on:click="showAllRooms">Show all rooms</ion-button>
    </span>
    <FooterSegment></FooterSegment>
</template>

<script lang="ts">
import SearchForRoomsCard from "../components/organisms/SearchForRoomsCard.vue";
import FooterSegment from '../components/FooterSegment.vue';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import ImageCarousel from "@/components/molecules/ImageCarousel.vue";
import HeaderTitle from "@/components/atoms/HeaderTitle.vue";

export default {
  name: 'LandingTemplate',
  components: {HeaderTitle, ImageCarousel, FooterSegment, SearchForRoomsCard},
  setup() {
    const router = useRouter();

    const fullText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Additional details here. Continue the description of the text, providing more in-depth information. This area can be used to extend any type of content or information you wish to remain initially hidden.";
    const truncatedLength = 120;
    const showMoreText = ref(false);
    const searchModel = ref({
      startDateModel: {
        label: 'Pick Start Date:',
        date: ''
      },
      endDateModel: {
        label: 'Pick End Date:',
        date: ''
      }
    })

    const displayedText = computed(() => {
      return showMoreText.value ? fullText : fullText.substring(0, truncatedLength) + '...';
    });

    function toggleMoreText() {
      showMoreText.value = true;
    }

    async function searchForRooms(start: string, end: string) {
      await router.push({ name: 'Search', query: { start: start, end: end } });
    }
  async function showAllRooms() {
      await router.push({ name: 'Search', query: { start: "", end: "" } });
  }

    return {
      searchModel,
      displayedText,
      toggleMoreText,
      searchForRooms,
      showMoreText,
        showAllRooms
    }
  }
}
</script>

<style scoped>
.image-container img {
  max-height: 100%;
  max-width: 100%;
  object-fit: contain;
}
span.text-center {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%; /* Ensure it takes full width for proper centering */
    margin: 20px 0; /* Optional: Add some margin for spacing */
}
</style>