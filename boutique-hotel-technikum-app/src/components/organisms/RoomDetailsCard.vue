<template>
  <ion-card class="room-details-card">
    <header-title :title="`${room.title}`"></header-title>
    <ImageAtom :filePath="`./images/rooms/${room.image}.jpg`"></ImageAtom>
    <ion-card-content>
      <TextLabel text="DATES"/>
      <TextLabel :text="`From: ${formatDate(start)} To: ${formatDate(end)}`"/>
      <TextLabel text="DETAILS"/>
      <TextLabel :text="room.description"/>
      <TextLabel text="EXTRAS"/>
      <span class="style-children">
        <div v-if="iconPathList.length > 0" v-for="(icon, index) in iconPathList" :key="icon">
            <ion-icon class="right-padding" :src="icon"></ion-icon>
        </div>
      </span>
      <ion-card-header>
        <ion-card-title>Price Summary</ion-card-title>
      </ion-card-header>
      <TextLabel :text="`Nights: ${getNights()}`"/>
      <TextLabel :text="`Price per Night: €${room.price}`"/>
      <TextLabel :text="`Total Price: €${getTotalPrice().toFixed(2)}`"/>
      <ion-button :disabled="isDisabled" expand="block" @click="onConfirmPayment">Payment Details</ion-button>
    </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
import { IonIcon } from '@ionic/vue';
import { useRoomExtraStore } from "@/stores/roomExtras";
import { differenceInCalendarDays, parseISO } from 'date-fns';
import TextLabel from "@/components/atoms/Label.vue";
import {useExtraTypeStore} from "@/stores/extraType";
import {ref} from "vue";
import {useRoomsStore} from "@/stores/room";
import {useRouter} from "vue-router";
import ImageAtom from "@/components/atoms/Image.vue";
import HeaderTitle from "@/components/atoms/HeaderTitle.vue";

export default {
  name: 'RoomDetailsCard',
  components: {HeaderTitle, ImageAtom, TextLabel, IonIcon },
  props: ["room", "start", "end"],
  setup() {
    const router = useRouter();

    async function goToPayment(id: number, start: string, end: string) {
      await router.push({ name: 'Payment', query: { id: id, start: start, end: end } });
    }

    return {
      goToPayment
    }
  },
  data() {
    return {
      roomObject: this.room,
      roomStore: useRoomsStore(),
      roomExtraStore: useRoomExtraStore(),
      extraTypeStore: useExtraTypeStore(),
      extraList: ref<any[]>([]),
      iconPathList: [''],
      isDisabled: !this.start || !this.end,
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
    getNights() {
      const start = this.start;//parseISO(this.start);
      const end = this.end;//parseISO(this.end);
      return Math.max(differenceInCalendarDays(end, start), 0);
    },
    getTotalPrice() {
      return this.getNights() * this.room.price;
    },
    onConfirmPayment() {
      this.goToPayment(this.room.id, this.start, this.end);
    },
    formatDate(date: string) {
      return new Date(date).toLocaleDateString();
    }
  }
};
</script>

<style scoped>
.room-details-card {
  padding: 16px;
}
ion-card-content {
  padding: 16px;
}

ion-button {
  margin: 16px;
}
p {
  margin: 8px 0;
}
span.style-children {
  display: flex;
  flex-direction: row;
}
ion-icon.right-padding {
  padding-right: 0.25rem;
}
</style>
