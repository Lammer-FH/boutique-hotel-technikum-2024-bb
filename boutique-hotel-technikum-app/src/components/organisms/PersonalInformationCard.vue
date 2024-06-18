<template>
    <ion-card>
        <ion-card-content>
            <BookingDetail label="Full name">Jane Doe</BookingDetail>
            <BookingDetail label="E-Mail">jane.doe@gmail.com</BookingDetail>
            <BookingDetail label="Telephone phone">0660123456</BookingDetail>
        </ion-card-content>
    </ion-card>
</template>

<script>
import BookingDetail from '../molecules/BookingDetail.vue';

export default {
    name: 'PersonalInformationCard',
    components: {
        BookingDetail
    }
};
</script>