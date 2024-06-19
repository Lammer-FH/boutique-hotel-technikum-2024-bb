<template>
  <ion-page>

    <RoomDetailsCard :room="room" :start="startDate" :end="endDate" />
    room id: {{ room.roomId}}
  </ion-page>
</template>

<script lang="ts">
import RoomDetailsCard from "@/components/organisms/RoomDetailsCard.vue";

export default {
  components: {RoomDetailsCard},
  props: ['room', 'startDate', 'endDate'],

}
</script>

<style scoped>

</style>