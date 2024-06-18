<template>
    <ion-label>Personal Information</ion-label>
    <ion-list>
        <ion-item>
            <ion-input label="Name" :value="name" @ionInput="$emit('update:name', $event.target.value)"></ion-input>
        </ion-item>
        <ion-item>
            <ion-input label="Surname" :value="surname" @ionInput="$emit('update:surname', $event.target.value)"></ion-input>
        </ion-item>
        <ion-item>
            <ion-input label="Telephone phone" :value="phoneNumber" @ionInput="$emit('update:phoneNumber', $event.target.value)"></ion-input>
        </ion-item>
        <ion-item>
            <ion-input label="Address" :value="address" @ionInput="$emit('update:address', $event.target.value)"></ion-input>
        </ion-item>
        <ion-item>
            <ion-input label="Email" type="email" :value="email" @ionInput="$emit('update:email', $event.target.value)"></ion-input>
        </ion-item>
        <ion-item>
            <ion-input label="Confirm Email" type="email" :value="confirmEmail" @ionInput="$emit('update:confirmEmail', $event.target.value)"></ion-input>
        </ion-item>
        <ion-item>
            <breakfast-option :value="includeBreakfast" @change="$emit('update:includeBreakfast', $event)"></breakfast-option>
        </ion-item>
    </ion-list>
</template>

<script>
import InputField from '@/components/atoms/InputField.vue';
import BreakfastOption from '@/components/molecules/BreakfastOption.vue';

export default {
    name: 'PersonalInformationForm',
    components: {
        InputField,
        BreakfastOption
    },
    props: {
        name: String,
        surname: String,
        phoneNumber: String,
        address: String,
        email: String,
        confirmEmail: String,
        includeBreakfast: String
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