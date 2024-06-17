<template>
    <ion-card>
        <ion-card-content>
            <BookingDetail label="Booking-Number">1234</BookingDetail>
            <BookingDetail label="Status">Confirmed</BookingDetail>
            <BookingDetail label="Check-in">July 06, 2024</BookingDetail>
            <BookingDetail label="Check-out">July 07, 2024</BookingDetail>
            <BookingDetail label="Total">0,00€</BookingDetail>
            <BookingDetail label="Breakfast">Included</BookingDetail>
        </ion-card-content>
    </ion-card>
</template>

<script>
import BookingDetail from '../molecules/BookingDetail.vue';

export default {
    name: 'BookingDetailsConfirmed',
    components: {
        BookingDetail
    }
};
</script>