<template>
    <ion-page>
        <ion-content :fullscreen="true" class="ion-padding">
            <h1>Booking Confirmed</h1>
            <p>We are pleased to inform you that your reservation request has been received and confirmed. Thank you!</p>
            <h2>Booking Details</h2>
            <BookingDetailsConfirmed />
            <RoomCard/>
            <h2>Personal Information</h2>
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