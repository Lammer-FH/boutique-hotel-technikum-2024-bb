

<template>
  <ion-card class="text-style">
    <ion-card-content >
      <DatePicker :date-model="searchModel.startDateModel" v-model="searchModel.startDateModel"></DatePicker>
      <DatePicker :date-model="searchModel.endDateModel" v-model="searchModel.endDateModel"></DatePicker>
      <span class="text-center">
        <ion-button size="small" class="text-style" shape="round" v-on:click="searchForRooms">Search</ion-button>
      </span>
    </ion-card-content>
  </ion-card>

</template>

<script lang="ts">
import DatePicker from "@/components/atoms/DatePicker.vue";



export default {
  name: 'SearchForRoomsCard',
  components: {DatePicker},
  props: ["searchModel"],
  methods: {
    // todo click event search
    searchForRooms(){
      if(this.searchModel.startDateModel.date > this.searchModel.endDateModel.date){
        // todo error
        console.log("end date before start date not possible!")
      }
      else {
        console.log("search for rooms for start: " +  this.searchModel.startDateModel.date + " and end: " + this.searchModel.endDateModel.date);
        this.$emit("search-for-rooms", this.searchModel.startDateModel.date, this.searchModel.endDateModel.date);
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