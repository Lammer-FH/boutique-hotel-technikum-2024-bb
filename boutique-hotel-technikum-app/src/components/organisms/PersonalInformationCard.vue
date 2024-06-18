<template>
    <ion-card>
        <ion-card-content>
            <BookingDetail label="Full name">Jane Doe</BookingDetail>
            <BookingDetail label="Email">jane.doe@gmail.com</BookingDetail>
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