<template>
    <ion-page>
        <ion-content :fullscreen="true" class="ion-padding">
            <h1 class="ion-text-center">Booking Confirmed</h1>
            <p class="ion-text-center">We are pleased to inform you that your reservation request has been received and confirmed. Thank you!</p>
            <h4>Booking Details</h4>
            <BookingDetailsConfirmed :title="title"/>
            <RoomCard v-if="room.length > 0" :room="room[0]" />
            <div>
              {{room.value}}
            </div>
            <h4>Personal Information</h4>
            <PersonalInformationCard />
            <FooterSegment />
        </ion-content>
    </ion-page>
</template>

<script lang="ts">
import BookingDetailsConfirmed from '@/components/organisms/BookingDetailsConfirmed.vue';
import RoomCard from './molecules/RoomCard.vue';
import PersonalInformationCard from '@/components/organisms/PersonalInformationCard.vue';
import FooterSegment from './FooterSegment.vue';
import {useRoomsStore} from "@/stores/room.js";
import {ref} from "vue";

export default {
    name:"BookingConfirmationTemplate",
    components: {
        BookingDetailsConfirmed,
        RoomCard,
        PersonalInformationCard,
        FooterSegment
    },
    props: ['title', 'roomId'],
  data () {
    return{
      roomStore: useRoomsStore(),
      room: ref<any[]>([]),
      roomoom: {}
    }
  },
  async mounted() {
    console.log("trying to getch room");
    await this.getRoom()
  },
    methods: {
      async getRoom() {
        if (!this.roomId) {
          console.error("Room ID is required to fetch room details.");
          return;
        }
        console.log(`Fetching room details for ID: ${this.roomId}`);
        if (this.room.length > 0) {
          this.room.splice(0);
        }
        this.room.push(await this.roomStore.fetchRoomById(this.roomId));
        console.log("room:::: roomId " + this.roomId)
        console.log(this.room[0])
        //this.roomoom = this.room.pop()
      },
  },
};
</script>