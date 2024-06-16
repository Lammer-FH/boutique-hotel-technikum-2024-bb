<template>
    <ion-label :position="position">Include Brea</ion-label>
    <ion-radio-group v-bind="includeBreakfast" @ionChange="$emit('update:includeBreakfast', includeBreakfast)">
        <radio-button label="Yes" value="yes"></radio-button>
        <radio-button label="No" value="no"></radio-button>
    </ion-radio-group>
</template>
  
<script>
    import RadioButton from '@/components/atoms/RadioButton.vue';
    
    export default {
        name: 'BreakfastOption',
        components: {
            RadioButton
        },
        props: {
            includeBreakfast: String
        }
    };
</script>
  