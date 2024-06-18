<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Header</ion-title>
      </ion-toolbar>

      <router-link to="/">Go Home</router-link>
      <router-link to="/123">Go Also Home</router-link>
      <router-link to="/3">Profile?</router-link>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Blank</ion-title>
        </ion-toolbar>
      </ion-header>


      <div id="container">
        <strong>Ready to create an app?</strong>
        <p>Start with Ionic <a target="_blank" rel="noopener noreferrer" href="https://ionicframework.com/docs/components">UI Components</a></p>
        <button @click="getRoomExtrasForRoom">Create Booking Button</button>
      </div>
      <SearchOverviewPage></SearchOverviewPage>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
// Example how to use store
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import DatePicker from "@/components/atoms/DatePicker.vue";
import SearchOverviewPage from "@/views/SearchRoomsPage.vue";
import { useCustomerStore } from '@/stores/customer'
import {ref} from "vue";
import {useRoomsStore} from "@/stores/room";
import {useBookingStore} from "@/stores/booking";
import {useExtraTypeStore} from "@/stores/extraType";
import {useRoomExtraStore} from "@/stores/roomExtras";

      const customer = useCustomerStore();
      const rooms = useRoomsStore();
      const bookings = useBookingStore();
      const extraType = useExtraTypeStore();
      const roomExtra = useRoomExtraStore();
      const form = ref({
      name: 'aa',
      surname: 'bb',
      email: 'cc@gmail.com',
      phoneNumber: 'ccc',
      address: 'dd'
      });
      function fetchCustomerData()  {
          customer.readState(1)
      }
      function createCustomer()  {
          customer.createCustomer("testName","testSurname","4986","testaddress","test@gmail.com")
      }
      function updateCustomer()  {
          customer.updateCustomer(1,"testName","testSurname","4986","testaddress","test@gmail.com")
      }
      function fetchAllRooms(){
          rooms.fetchRooms()
          }
      function fetchRoomById(){
        rooms.fetchRoomById(1)
      }
      function createBooking(){
          bookings.createBooking("ttl","a",1,2,"2024-07-30","2024-08-30",true,40)
      }
      function getExtraType(){
          extraType.getExtraType(1)
      }
      function getRoomExtrasForRoom(){
          roomExtra.fetchRoomExtrasForRoom(3)
      }
</script>

<style scoped>
#container {
  text-align: center;
  
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  transform: translateY(-50%);
}

#container strong {
  font-size: 20px;
  line-height: 26px;
}

#container p {
  font-size: 16px;
  line-height: 22px;
  
  color: #8c8c8c;
  
  margin: 0;
}

#container a {
  text-decoration: none;
}
</style>
