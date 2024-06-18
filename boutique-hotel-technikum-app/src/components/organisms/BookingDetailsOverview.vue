<template>
    <div class="details">
        <p>Dates: <strong>From: {{ fromDate }} To: {{ toDate }}</strong></p>
        <p>Nights: <strong>{{ nights }}</strong></p>
        <p>Guests: <strong>{{ guests }}</strong></p>
        <p>Room: <strong>{{ room }}</strong></p>
        <p>Total: <strong>{{ total }}</strong></p>
    </div>
</template>

<script>
export default {
    name: "BookingDetailsOverview",
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

<style scoped>
    .details p {
        margin: 5px 0;
    }
</style>