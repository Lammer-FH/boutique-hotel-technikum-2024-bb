<script setup>

const props = defineProps({
  title: {
    type: String,
    default: ""
  }
});

</script>

<template>
    <ion-header>
      <ion-toolbar>
        <ion-title slot="start">{{ props.title }}</ion-title>
        <router-link slot="end" to="/welcome"><ion-button>HOME</ion-button></router-link>
      </ion-toolbar>
    </ion-header>
</template>

<style scoped>

</style>