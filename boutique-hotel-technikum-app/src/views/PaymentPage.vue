<template>
    <PaymentTemplate 
        :fromDate="fromDate"
        :toDate="toDate"
        :nights="nights"
        :guests="guests"
        :room="room"
        :total="total"
    />
</template>

<script>
import PaymentTemplate from '@/components/PaymentTemplate.vue';

export default {
    name: 'PaymentPage',
    components: {
        PaymentTemplate
    },
    data: () => {
        return {
            fromDate: "July 06",
            toDate: "July 07",
            nights: 1,
            guests: "1 Student",
            room: "1 Basic Single Bedroom",
            total: "0,00"
        }
    }
};
</script>

<style scoped>
ion-card-content {
  padding-top: 0;
}
ion-button {
  margin-top: 20px;
}
</style>