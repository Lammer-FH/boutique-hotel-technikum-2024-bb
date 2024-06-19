<template>
    <ion-card>
        <ion-card-title>Contact</ion-card-title>
        <ion-card-content>
            <BookingDetail label="Phone">+43 1234 567890</BookingDetail>
            <BookingDetail label="Email">boutique-usa@gmail.com</BookingDetail>
            <BookingDetail label="Address">Höchstädtpl. 6, 1200 Wien</BookingDetail>
        </ion-card-content>
    </ion-card>
</template>

<script>
import BookingDetail from '../molecules/BookingDetail.vue';

export default {
    name: 'Contact',
    components: {
        BookingDetail
    }
};
</script>