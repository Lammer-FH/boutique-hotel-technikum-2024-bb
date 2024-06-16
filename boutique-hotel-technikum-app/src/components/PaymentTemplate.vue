<template>
    <BookingDetailsOverveiw
        :fromDate="fromDate"
        :toDate="toDate"
        :nights="nights"
        :guests="guests"
        :room="room"
        :total="total"
    />
    <PersonalInformationForm />
</template>

<script>
import BookingDetailsOverveiw from '@/components/organisms/BookingDetailsOverview.vue';
import PersonalInformationForm from '@/components/organisms/PersonalInformationForm.vue';

export default {
    name:"PaymentTemplate",
    components: {
        BookingDetailsOverview,
        PersonalInformationForm,
    },
    props: {
        fromDate: String,
        toDate: String,
        nights: Number,
        guests: String,
        room: String,
        total: String
    }
};
</script>