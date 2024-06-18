<template>
    <ion-item>
        <ion-label>{{ label }}</ion-label>
        <slot></slot>
    </ion-item>
</template>

<script>
export default {
    name: 'BookingDetail',
    props: {
        label: {
        type: String,
        required: true
        }
    }
};
</script>