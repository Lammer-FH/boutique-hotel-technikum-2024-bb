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