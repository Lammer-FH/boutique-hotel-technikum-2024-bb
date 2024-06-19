<template>
    <ion-card>
        <ion-card-content>
            <BookingDetail label="Room">{{ title }}</BookingDetail>
            <BookingDetail label="Booking-Number">{{ this.bookings.id }}</BookingDetail>
            <BookingDetail label="Status" v-if="this.bookings.cancelled">Cancelled</BookingDetail>
            <BookingDetail label="Status" v-else>Confirmed</BookingDetail>
            <BookingDetail label="Check-in">{{ this.bookings.bookingStart }}</BookingDetail>
            <BookingDetail label="Check-out">{{ this.bookings.bookingEnd }}</BookingDetail>
            <BookingDetail label="Total">{{ this.bookings.totalCost }}</BookingDetail>
            <BookingDetail label="Breakfast" v-if="this.bookings.breakfast">Included</BookingDetail>
            <BookingDetail label="Breakfast" v-else>Not Included</BookingDetail>
        </ion-card-content>
    </ion-card>
</template>

<script>
import BookingDetail from '../molecules/BookingDetail.vue'; 
import {useBookingStore} from "@/stores/booking";

export default {
    name: 'BookingDetailsConfirmed',
    components: {
        BookingDetail
    },
    data: () =>{
        return{
            bookings: useBookingStore()
        }
    },
    props: {
        title: String
    }
};
</script>