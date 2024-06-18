<template>
    <ion-label :position="position">Include Breakfast</ion-label>
    <ion-radio-group v-bind="includeBreakfast" v-model="picked" @ionChange="updateBreakfast">
        <radio-button label="Yes" value="yes" ></radio-button>
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
        },
        data() {
            return {
                picked: this.includeBreakfast
            };
        },
        watch: {
            includeBreakfast(newValue) {
                this.picked = newValue;
            }
        },
        methods: {
            updateBreakfast(event) {
                this.$emit('update:includeBreakfast', event.detail.value);
            }
        }
    };
</script>
  