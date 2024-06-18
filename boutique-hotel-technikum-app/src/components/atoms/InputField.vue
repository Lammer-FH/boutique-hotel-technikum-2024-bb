<template>
    <ion-item>
        <ion-label :position="position">{{ label }}</ion-label>
        <ion-input v-bind="inputValue" :type="type" @input="$emit('update:inputValue', inputValue)"></ion-input>
    </ion-item>
</template>
  
<script>
    export default {
        name: 'InputField',
        props: {
        label: String,
        inputValue: String,
        type: {
            type: String,
            default: 'text'
        },
        position: {
            type: String,
            default: 'floating'
        }
        }
    };
</script>
  