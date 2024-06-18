<script lang="ts">

export default {
    name: 'RoomImage',
    props: {
        fileName: {
            type: String,
            required: true
        }
    },
}
</script>

<template>
    <img class="image-width" alt="Room Image" :src="`./images/rooms/${fileName}.jpg`" />

</template>

<style scoped>
</style>