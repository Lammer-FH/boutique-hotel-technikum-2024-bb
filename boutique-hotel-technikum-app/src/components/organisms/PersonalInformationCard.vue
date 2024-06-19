<template>
    <ion-card>
        <ion-card-content>
            <BookingDetail label="Full name" :value="customer.name"></BookingDetail>
            <BookingDetail label="E-Mail" :value="customer.email"></BookingDetail>
            <BookingDetail label="Telephone phone" :value="customer.phoneNumber"></BookingDetail>
        </ion-card-content>
    </ion-card>
</template>

<script>
import BookingDetail from '../molecules/BookingDetail.vue';
import { useCustomerStore } from '@/stores/customer';

export default {
    name: 'PersonalInformationCard',
    components: {
        BookingDetail
    },
    data: () =>{
        return{
            customerStore: useCustomerStore(),
            customer: this.customerStore.customer
        }
    }
};
</script>