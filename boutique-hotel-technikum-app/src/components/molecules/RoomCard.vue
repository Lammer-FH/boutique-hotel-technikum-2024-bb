<template>
  <ion-card class="height style-children">
    <RoomImage></RoomImage>
    <ion-card-header >
      <ion-card-title>{{room.title}}</ion-card-title>
      <ion-card-subtitle>{{room.price}}/Night</ion-card-subtitle>
    </ion-card-header>

      <ion-card-content>
        <p>Beds: {{ room.bedCount}}</p>
        <ion-icon src="./icons/bathtub.svg"></ion-icon>
        <ion-icon src="./icons/hairdryer.svg"></ion-icon>
        <ion-icon src="./icons/balcony.svg"></ion-icon>
        <ion-icon src="./icons/coffeemachine.svg"></ion-icon>
        <ion-icon src="./icons/watercooker.svg"></ion-icon>
        <ion-icon src="./icons/wifi.svg"></ion-icon>


        <ion-button shape="round" @click="selectRoom">Select Room</ion-button>
      </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
import RoomImage from "@/components/atoms/RoomImage.vue";
import { IonIcon } from '@ionic/vue';

export default {
  name: 'RoomCard',
  components: {RoomImage, IonIcon},
  props: ["roomObject", "roomIndex"],
  data() {
    return {
      room: this.roomObject
    }
  },
  methods: {
    selectRoom() {
      console.log("select room triggered for room id " + this.roomObject.id)
      this.$emit("selectroom", this.roomIndex)
    }
  }
}
</script>

<style scoped>
/* Add custom styling for the label */
ion-card.height {
  height: 8rem;
}

ion-card.style-children {
  display: flex;
  flex-direction: row;
}
span.style-columns {
  display: flex;
  flex-direction: row;
}
img.image-width {
  width: 30%;
}
</style>