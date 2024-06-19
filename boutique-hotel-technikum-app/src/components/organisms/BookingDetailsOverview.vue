<template>
    <div class="details">
        <ion-card>
            <ion-grid>
                <ion-row>
                    <ion-col size="3">Dates:</ion-col>
                    <ion-col>
                        <ion-row>
                            <strong>From: {{ fromDate }}</strong>
                        </ion-row>
                        <ion-row>
                            <strong>To: {{ toDate }}</strong>
                        </ion-row> 
                    </ion-col>
                </ion-row>
                <ion-row>
                    <ion-col size="3">Room:</ion-col>
                    <ion-col><strong>{{ room }}</strong></ion-col>
                </ion-row>
                <ion-row>
                    <ion-col size="3">Nights:</ion-col>
                    <ion-col><strong>{{ nights }}</strong></ion-col>
                </ion-row>
                <ion-row>
                    <ion-col size="3">Total:</ion-col>
                    <ion-col><strong>{{ total }}</strong></ion-col>
                </ion-row>
            </ion-grid>
        </ion-card>
    </div>
</template>

<script>
export default {
    name: "BookingDetailsOverview",
    props: {
        fromDate: String,
        toDate: String,
        nights: String,
        room: String,
        total: String
    }
};
</script>

<style scoped>
    .details p {
        margin: 5px 0;
    }
    ion-card{
        border: none;
        margin-bottom: 40px;
    }
</style>