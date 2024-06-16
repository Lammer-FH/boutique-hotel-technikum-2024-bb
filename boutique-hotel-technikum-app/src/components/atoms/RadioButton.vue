<template>
    <ion-item>
        <ion-label>{{ label }}</ion-label>
        <ion-radio slot="start" :value="value"></ion-radio>
    </ion-item>
</template>
  
<script>
    export default {
        name: 'RadioButton',
        props: {
        label: String,
        value: String
        }
    };
</script>
  