<template>
  <ion-grid>
    <ion-row>
      <ion-col>
        <ImageAtom :filePath="`./images/rooms/${room.image}.jpg`"></ImageAtom>
      </ion-col>
      <ion-col>
        <h4 class="tiny-margin">{{room.title}}</h4>
        <p class="tiny-margin">{{ room.description}}</p>
        <span class="style-children">
          <div v-if="iconPathList.length > 0" v-for="(icon, index) in iconPathList" :key="icon">
            <ion-icon class="right-padding" :src="icon"></ion-icon>
          </div>
        </span>
        <ion-button size="small" shape="round" @click="goToRoomDetails">Details</ion-button>
      </ion-col>
    </ion-row>
  </ion-grid>

</template>

<script lang="ts">
import ImageAtom from "@/components/atoms/Image.vue";
import { IonIcon } from '@ionic/vue';
import {useRoomExtraStore} from "@/stores/roomExtras";
import {ref} from "vue";
import {useExtraTypeStore} from "@/stores/extraType";
import {useRouter} from "vue-router";

export default {
  name: 'RoomCard',
  components: {ImageAtom, IonIcon},
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
    async getRoomExtras() {
      await this.roomExtraStore.fetchRoomExtrasForRoom(this.room.id);
      this.extraList = this.roomExtraStore.roomExtras;
      console.log("extra list for id = " + this.room.id);
      console.log(this.extraList)
    },
    getIconLinks(){
      this.extraList.forEach((extra) => {
        console.log('Processing extra:', extra);
        if(extra !== '')
        {
          const iconLink = this.getIconPathForExtra(extra.title);
          this.iconPathList.push(iconLink.toString());
        }

      });
    },
    getIconPathForExtra(extra){
      console.log("in path extra = " + extra);
      return './icons/' + extra + ".svg";
    },
    goToRoomDetails() {
      console.log("emit from roomcard");
      this.$emit('goToDetails', this.room.id);
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
  width: 100%; /* Makes the image take up the full width of its container */
  height: 7rem; /* Set a fixed height for all images */
  object-fit: cover; /* Ensures images cover the area without stretching */
}
ion-icon.right-padding {
  padding-right: 0.25rem;
}
h3.tiny-margin {
  margin: 0.25rem;
}
p.tiny-margin {
  margin: 0.25rem;
}
</style>




