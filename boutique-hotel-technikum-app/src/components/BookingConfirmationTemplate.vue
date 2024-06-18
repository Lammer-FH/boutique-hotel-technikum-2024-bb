<template>
    <ion-page>
        <ion-content :fullscreen="true" class="ion-padding">
            <h1 class="ion-text-center">Booking Confirmed</h1>
            <p class="ion-text-center">We are pleased to inform you that your reservation request has been received and confirmed. Thank you!</p>
            <h4>Booking Details</h4>
            <BookingDetailsConfirmed />
            <RoomCard/>
            <h4>Personal Information</h4>
            <PersonalInformationCard />
            <Contact />
        </ion-content>
    </ion-page>
</template>

<script>
import BookingDetailsConfirmed from '@/components/organisms/BookingDetailsConfirmed.vue';
import PersonalInformationCard from '@/components/organisms/PersonalInformationCard.vue';
import Contact from '@/components/organisms/Contact.vue';

export default {
    name:"BookingConfirmationTemplate",
    components: {
        BookingDetailsConfirmed,
        PersonalInformationCard,
        Contact
    }
};
</script>