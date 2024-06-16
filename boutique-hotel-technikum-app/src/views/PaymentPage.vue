<template>
    <ion-page>
        <ion-content :fullscreen="true" class="ion-padding">
            <h1>Payment Details</h1>
            <ion-card>
                <ion-card-content>
                    <BookingDetailsOverview
                    :fromDate="fromDate"
                    :toDate="toDate"
                    :nights="nights"
                    :guests="guests"
                    :room="room"
                    :total="total"
                    />
                </ion-card-content>
            </ion-card>
            <PersonalInformationForm/>
        </ion-content>
    </ion-page>
</template>

<script>
import BookingDetailsOverview from '@/components/organisms/BookingDetailsOverview.vue';
import PersonalInformationForm from '@/components/organisms/PersonalInformationForm.vue';

export default {
    name: 'PaymetPage',
    components: {
        BookingDetailsOverview,
        PersonalInformationForm
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