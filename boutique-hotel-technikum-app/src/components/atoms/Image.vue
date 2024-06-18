<script lang="ts">

export default {
    name: 'ImageAtom',
    props: {
        filePath: {
            type: String,
            required: true
        }
    },
}
</script>

<template>
    <img class="image-width" alt="Room Image" :src=filePath />

</template>

<style scoped>
</style>