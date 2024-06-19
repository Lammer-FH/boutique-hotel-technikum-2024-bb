<template>
  <ion-page>
      <ion-header>
        <ion-toolbar>
        </ion-toolbar>
      </ion-header>
      <ion-content >
      <form @submit.prevent="saveBooking">
          <PaymentTemplate 
              :fromDate="startDate"
              :toDate="endDate"
              :room="roomTitle"
              :nights="nights"
              :total="totalPrice"
              :name="name"
              :surname="surname"
              :phoneNumber="phoneNumber"
              :address="address"
              :email="email"
              :confirmEmail="confirmEmail"
              :includeBreakfast="includeBreakfast"
              @update:name="updateName"
              @update:surname="updateSurname"
              @update:phoneNumber="updatePhoneNumber"
              @update:address="updateAddress"
              @update:email="updateEmail"
              @update:confirmEmail="updateConfirmEmail"
              @update:includeBreakfast="updateIncludeBreakfast"
          />
          <ion-button shape="round" type="submit">
              Order
              <ion-icon slot="end" :icon="chevronForward "></ion-icon>
          </ion-button>
          <ion-alert 
              :is-open="showAlert"
              :header="alertHeader"
              :message="alertMessage"
              :buttons="alertButton"
              @didDismiss="showAlert = false">
          </ion-alert>
      </form>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import PaymentTemplate from '@/components/PaymentTemplate.vue';
import { useCustomerStore } from '@/stores/customer'
import {useBookingStore} from "@/stores/booking";
import {useRoomsStore} from "@/stores/room";
import {useRouter} from 'vue-router';
import {chevronForward} from "ionicons/icons";
import { watch } from 'vue';
import { useRoute } from 'vue-router';




export default {
    name: 'PaymentPage',
    components: {PaymentTemplate },
    setup() {
      const router = useRouter();
      const route = useRoute();

      const roomId = route.query.id;
      const roomTitle = route.query.title;
      const startDate = route.query.start;
      const endDate = route.query.end;
      const nights = route.query.nights;
      const totalPrice = route.query.totalPrice;
      watch(() => route.path, () => {});

      async function routeToConfimationpage() {
        await router.push({ name: 'Booking Confirmation', query: { id: roomId, start: startDate, end: endDate, title: roomTitle} });
      }

      return {
        routeToConfimationpage,
        roomId,
        startDate,
        endDate,
        roomTitle,
        nights,
        totalPrice
      }
    },
    data: () => {
        return {
            customer: useCustomerStore(),
            bookings: useBookingStore(),
            roomStore: useRoomsStore(),
            fromDate: "",
            toDate: "",
            room: "",
            nights: "",
            total: "",
            name: '',
            surname: '',
            phoneNumber: '',
            address: '',
            email: '',
            confirmEmail: '',
            includeBreakfast: '',
            showAlert: false,
            alertHeader: '',
            alertMessage: '',
            alertButton: ['OK'],
        }
    },
    methods: {
      chevronForward() {
        return chevronForward
      },
        updateName(value) { this.name = value; },
        updateSurname(value) { this.surname = value; },
        updatePhoneNumber(value) { this.phoneNumber = value; },
        updateAddress(value) { this.address = value; },
        updateEmail(value) { this.email = value; },
        updateConfirmEmail(value) { this.confirmEmail = value; },
        updateIncludeBreakfast(value) { this.includeBreakfast = value; },
        async saveBooking() {
            try {
                // Validation
                if (!this.name || !this.surname || !this.phoneNumber || !this.address || !this.email || !this.confirmEmail) {
                    throw new Error('All fields are required.');
                }
                if (this.email !== this.confirmEmail) {
                    throw new Error('Emails do not match.');
                }
                let rooms = await this.searchForRooms();
                let available = this.checkRoomAvailability(rooms,this.roomId)

                if(available){
                    let guest = await this.saveGuest();
                    this.createBooking(guest);
                    await this.routeToConfimationpage();
                }
                else{
                    throw new Error('Room is not available.');
                }
            } catch (error) {
                this.showError(error.message);
                console.error("Error saving booking:", error);
            }
        },
        async saveGuest(){
            let guest = await this.customer.createCustomer(this.name, this.surname, this.phoneNumber, this.address, this.email)
            return guest;
        },
        async createBooking(guest){
            let breakfastOption = this.includeBreakfast == 'yes' ? true : false
            let totalCost = parseFloat(this.totalPrice)
            let booking = await this.bookings.createBooking(this.room,"notes",guest.id,1,this.startDate,this.endDate,breakfastOption,totalCost)
            console.log(booking);
        },
        showError(message) {
            this.alertHeader = 'Error';
            this.alertMessage = message;
            this.showAlert = true;
        },
        async searchForRooms() {
            console.log("fetchRoomsByDates");
            console.log(this.startDate);
            console.log(this.endDate);
            let rooms = await this.roomStore.fetchRoomsByDates(this.startDate, this.endDate);
            return rooms;
        },
        checkRoomAvailability(rooms, roomId){
            let available = false;
            rooms.forEach((room) => {
                if(room.id == roomId) {
                    available = true;
                }
            })
            return available;
        }
    }
};
</script>

<style scoped>
ion-card-content {
  padding-top: 0;
}
ion-button {
  margin-top: 20px;
}
</style>