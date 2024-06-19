<template>
    <BookingDetailsOverview
        :fromDate="fromDate"
        :toDate="toDate"
        :room="room"
        :nights="nights"
        :total="total" />
    <PersonalInformationForm 
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
        @update:includeBreakfast="updateIncludeBreakfast"/>
</template>

<script>
import BookingDetailsOverview from '@/components/organisms/BookingDetailsOverview.vue';
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
        room: String,
        nights: String,
        total: String,
        name: String,
        surname: String,
        phoneNumber: String,
        address: String,
        email: String,
        confirmEmail: String,
        includeBreakfast: String
    },
    methods: {
        updateName(value) { this.$emit('update:name', value); },
        updateSurname(value) { this.$emit('update:surname', value); },
        updatePhoneNumber(value) { this.$emit('update:phoneNumber', value); },
        updateAddress(value) { this.$emit('update:address', value); },
        updateEmail(value) { this.$emit('update:email', value); },
        updateConfirmEmail(value) { this.$emit('update:confirmEmail', value); },
        updateIncludeBreakfast(value) { this.$emit('update:includeBreakfast', value); },
    }
};
</script>