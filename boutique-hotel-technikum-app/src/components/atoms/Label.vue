<template>
    <p>{{ text }}</p>
</template>

<script>
export default {
    name: 'TextLabel',
    props: {
        text: {
        type: String,
        required: true
        }
    }
};
</script>

<style scoped>
p {
    margin: 0;
}
</style>