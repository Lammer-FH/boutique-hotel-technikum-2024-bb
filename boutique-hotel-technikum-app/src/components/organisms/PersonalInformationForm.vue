<template>
    <ion-label>Personal Information</ion-label>
    <form @submit.prevent="submitForm">
        <input-field label="Name" v-model="name"></input-field>
        <input-field label="Surname" v-model="surname"></input-field>
        <input-field label="Email" type="email" v-model="email"></input-field>
        <input-field label="Confirm Email" type="email" v-model="confirmEmail"></input-field>
        <breakfast-option v-model="includeBreakfast"></breakfast-option>
        <ion-button shape="round" type="submit">
            Order
            <ion-icon slot="end" :icon="chevronForward "></ion-icon>
        </ion-button>
    </form>
</template>

<script>
import { IonButton, IonIcon } from '@ionic/vue';
import { chevronForward } from 'ionicons/icons';

import InputField from '@/components/atoms/InputField.vue';
import BreakfastOption from '@/components/molecules/BreakfastOption.vue';

export default {
    name: 'PersonalInformationForm',
    components: {
        IonButton,
        IonIcon,
        InputField,
        BreakfastOption
    },
    data() {
        return {
        name: '',
        surname: '',
        email: '',
        confirmEmail: '',
        includeBreakfast: 'yes'
        };
    },
    methods: {
        submitForm() {
        if (this.email !== this.confirmEmail) {
            alert('Emails do not match!');
            return;
        }
        alert('Form submitted!');
        }
    }
};
</script>