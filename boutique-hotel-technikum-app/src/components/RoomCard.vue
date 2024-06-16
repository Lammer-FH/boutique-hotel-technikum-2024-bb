<template>
  <ion-card class="height style-children">
    <img class="image-width" alt="Silhouette of mountains" src="https://ionicframework.com/docs/img/demos/card-media.png" />

    <ion-card-header >
      <ion-card-title>{{room.title}}</ion-card-title>
      <ion-card-subtitle>{{room.price}}/Night</ion-card-subtitle>
    </ion-card-header>

      <ion-card-content>
        <p>Beds: {{ room.beds}}</p>
        <div>[icons for extras]</div>

        <ion-button shape="round" @click="selectRoom">Select Room</ion-button>
      </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
export default {
  name: 'RoomCard',
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
  height: 25%;
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