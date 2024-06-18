<template>
  <ion-page>
    <ion-content :fullscreen="true" class="ion-padding">
      <SearchForRoomsCard @search-for-rooms="searchForRooms" :search-model="searchModel"></SearchForRoomsCard>
      <ion-card>
        <div class="image-container">
          <img src="" alt="Hotel Image">
        </div>
        <ion-card-content>
          Description or additional content related to the image.
        </ion-card-content>
      </ion-card>
      <ion-card>
        <ion-card-content class="text-with-button">
          <p>{{ displayedText }}<span v-if="!showMoreText">...</span></p>
          <ion-button v-if="!showMoreText" fill="clear" @click="toggleMoreText" class="read-more-button">Read More</ion-button>
        </ion-card-content>
      </ion-card>
      <FooterSegment></FooterSegment>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import SearchForRoomsCard from "../components/organisms/SearchForRoomsCard.vue";
import FooterSegment from '../components/FooterSegment.vue';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';

export default {
  name: 'LandingTemplate',
  components: {FooterSegment, SearchForRoomsCard},
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

    return {
      searchModel,
      displayedText,
      toggleMoreText,
      searchForRooms,
      showMoreText
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
.text-with-button {
  display: flex;
  align-items: center;
}
.read-more-button {
  margin-left: 8px;
  --padding: 0;
  --min-height: auto;
}
</style>