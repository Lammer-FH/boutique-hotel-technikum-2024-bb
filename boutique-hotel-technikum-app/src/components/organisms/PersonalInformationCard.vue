<template>
    <ion-card>
        <ion-card-content>
            <BookingDetail label="Full name">{{ this.customer.name }}</BookingDetail>
            <BookingDetail label="E-Mail">{{ this.customer.name }}</BookingDetail>
            <BookingDetail label="Telephone phone">{{ this.customer.phoneNumber }}</BookingDetail>
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
            customer: useCustomerStore(),
        }
    }
};
</script>