

<template>
  <ion-card class="text-style">
    <ion-card-content >
      <DatePicker :search-model="searchModel" v-model="searchModel"></DatePicker>
      <AmountOfGuestsPicker  @updateNumberOfGuests="updateNumberOfGuests" :number-of-guests="numberOfGuests"></AmountOfGuestsPicker>
      <span class="text-center">
        <ion-button size="small" class="text-style" shape="round" v-on:click="searchForRooms">Search</ion-button>
      </span>
    </ion-card-content>
  </ion-card>

</template>

<script lang="ts">
import DatePicker from "@/components/DatePicker.vue";
import AmountOfGuestsPicker from "@/components/AmountOfGuestsPicker.vue";
import number = CSS.number;

export default {
  name: 'SearchForRoomsCard',
  components: {AmountOfGuestsPicker, DatePicker},
  data() {
    return {
      numberOfGuests: 0,
      searchModel: {
        startDate: '',
        endDate: ''
      }
    }
  }, methods: {
    // todo click even search
    updateNumberOfGuests(update: number) {
      this.numberOfGuests = update;

    },
    searchForRooms(){
      if(this.searchModel.startDate === '' || this.searchModel.endDate === ''){
        // todo error
        console.log("no dates defined!")
      }
      else if(this.searchModel.startDate > this.searchModel.endDate){
        // todo error
        console.log("end date before start date not possible!")
      }
      else {
        // todo do a search
        // todo datumsformast richtig?????
        console.log("search for room for " + this.numberOfGuests + " guests from " + this.searchModel.startDate + " until " + this.searchModel.endDate);
      }
    }
  },
}
</script>

<style scoped>
ion-button.text-style {
  font-size: 1rem;
}
span.text-center {
  position: relative;
  align-content: center;
}
</style>