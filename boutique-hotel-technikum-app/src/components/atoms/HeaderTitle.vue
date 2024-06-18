<template>
    <h1 class="welcome-title">{{ title }}</h1>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';

const props = defineProps<{
    title: string
}>();
</script>

<style scoped>
.welcome-title {
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
    margin: 20px 0;
    color: #333;
}
</style>
