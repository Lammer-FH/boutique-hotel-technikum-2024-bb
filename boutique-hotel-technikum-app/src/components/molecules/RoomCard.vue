<template>
  <ion-card class="height style-children">
    <RoomImage></RoomImage>
    <ion-card-header >
      <ion-card-title>{{room.title}}</ion-card-title>
      <ion-card-subtitle>{{room.price}}/Night</ion-card-subtitle>
    </ion-card-header>

      <ion-card-content >
        <p>Beds: {{ room.bedCount}}</p>
        <span class="style-children">
          <div v-if="iconPathList.length > 0" v-for="(icon, index) in iconPathList" :key="icon">
            <ion-icon class="right-padding" :src="icon"></ion-icon>
          </div>
        </span>
        <ion-button shape="round" @click="selectRoom">Select Room</ion-button>
      </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
import RoomImage from "@/components/atoms/RoomImage.vue";
import { IonIcon } from '@ionic/vue';
import {useRoomExtraStore} from "@/stores/roomExtras";
import {ref} from "vue";
import {useExtraTypeStore} from "@/stores/extraType";

export default {
  name: 'RoomCard',
  components: {RoomImage, IonIcon},
  props: ["roomObject", "roomIndex"],
  data() {
    return {
      room: this.roomObject,
      roomExtraStore: useRoomExtraStore(),
      extraTypeStore: useExtraTypeStore(),
      extraList: ref<any[]>([]),
      iconPathList: ['']
    }
  },
  async mounted() {
      await this.getRoomExtras();
      this.getIconLinks();
  },
  methods: {
    selectRoom() {
      console.log("select room triggered for room id " + this.roomObject.id)
      this.$emit("selectroom", this.roomIndex)
    },
    async getRoomExtras() {
      await this.roomExtraStore.fetchRoomExtrasForRoom(this.room.id);
      this.extraList = this.roomExtraStore.roomExtras;
      console.log("extra list for id = " + this.room.id);
      console.log(this.extraList)
    },
    getIconLinks(){
      this.extraList.forEach((extra) => {
        // Perform your "before each" action here
        // For example, logging each item before getting its icon link
        console.log('Processing extra:', extra);

        // Then get the icon link for each extra
        const iconLink = this.getIconPathForExtra(extra.title);
        this.iconPathList.push(iconLink.toString());
      });
    },
    getIconPathForExtra(extra){
      console.log("in path extra = " + extra);
      return './icons/' + extra + ".svg";
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
span.style-children {
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
ion-icon.right-padding {
  padding-right: 0.25rem;
}
</style>




