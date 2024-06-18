<template>
  <ion-card class="height style-children">
    <ImageAtom :filePath="`./images/rooms/${room.image}.jpg`"></ImageAtom>
    <ion-card-header >
      <ion-card-title>{{room.title}}</ion-card-title>
      <ion-card-subtitle>{{room.price}}/Night</ion-card-subtitle>
    </ion-card-header>

      <ion-card-content>
        <p>Beds: {{ room.bedCount}}</p>
        <div>[icons for extras]</div>
        <ion-button shape="round" @click="selectRoom">Select Room</ion-button>
      </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
import ImageAtom from "@/components/atoms/Image.vue";

export default {
  name: 'RoomCard',
  components: {ImageAtom},
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