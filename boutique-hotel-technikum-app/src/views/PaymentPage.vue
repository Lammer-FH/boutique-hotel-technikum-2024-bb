<template>
    <form @submit.prevent="saveBooking">
        <PaymentTemplate 
            :fromDate="fromDate"
            :toDate="toDate"
            :nights="nights"
            :guests="guests"
            :room="room"
            :total="total"
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
        <ion-button shape="round" type="submit" >
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
</template>

<script>
import PaymentTemplate from '@/components/PaymentTemplate.vue';
import { useCustomerStore } from '@/stores/customer'
import {useBookingStore} from "@/stores/booking";
import {useRoomsStore} from "@/stores/room";

export default {
    name: 'PaymentPage',
    components: {
        PaymentTemplate
    },
    data: () => {
        return {
            customer: useCustomerStore(),
            bookings: useBookingStore(),
            roomStore: useRoomsStore(),
            fromDate: "2024-07-06",
            toDate: "2024-07-07",
            nights: 1,
            guests: "1 Student",
            room: "1 Basic Single Bedroom",
            total: "40,00",
            name: '',
            surname: '',
            phoneNumber: '',
            address: '',
            email: '',
            confirmEmail: '',
            includeBreakfast: 'yes',
            showAlert: false,
            alertHeader: '',
            alertMessage: '',
            alertButton: ['OK']
        }
    },
    methods: {
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

                let guest = await this.saveGuest();
                this.createBooking(guest);
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
            let totalCost = parseFloat(this.total)
            let booking = await this.bookings.createBooking(this.room,"notes",guest.id,1,this.fromDate,this.toDate,breakfastOption,totalCost)
            console.log(booking);
        },
        showError(message) {
            this.alertHeader = 'Error';
            this.alertMessage = message;
            this.showAlert = true;
        },
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