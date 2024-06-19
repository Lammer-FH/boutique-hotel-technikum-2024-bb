<template>
    <ion-page>
        <ion-content :fullscreen="true" class="ion-padding">
            <h1 class="ion-text-center">Booking Confirmed</h1>
            <p class="ion-text-center">We are pleased to inform you that your reservation request has been received and confirmed. Thank you!</p>
            <h4>Booking Details</h4>
            <BookingDetailsConfirmed :title="title"/>
            <RoomCard :roomObject="room" />
            <h4>Personal Information</h4>
            <PersonalInformationCard />
            <FooterSegment />
        </ion-content>
    </ion-page>
</template>

<script>
import BookingDetailsConfirmed from '@/components/organisms/BookingDetailsConfirmed.vue';
import RoomCard from './molecules/RoomCard.vue';
import PersonalInformationCard from '@/components/organisms/PersonalInformationCard.vue';
import FooterSegment from './FooterSegment.vue';

export default {
    name:"BookingConfirmationTemplate",
    components: {
        BookingDetailsConfirmed,
        RoomCard,
        PersonalInformationCard,
        FooterSegment
    },
    props: {
        title: String,
        roomObject: {}
    },
};
</script>