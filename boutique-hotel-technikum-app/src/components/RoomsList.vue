<template>
  <div v-if="roomList.length > 0" v-for="(room, index) in roomList" :key="room.id">
    <RoomCard :roomObject="room" :roomIndex="index" @selectroom="selectRoom"></RoomCard>
  </div>
  <p v-else>Keine Zimmer Verfügbar</p>
</template>

<script lang="ts">
import RoomCard from "@/components/RoomCard.vue";

export default {
  name: 'RoomsList',
  components: {RoomCard},
  data() {
    return {
      // todo get actual room list
      roomList: [
        {id: 1, beds: 4, selected: false, price: 12, title: "Single"},
        {id: 2, beds: 2,  selected: false, price: 12, title: "Single"},
        {id: 3, beds: 3,  selected: false, price: 12, title: "Single"},
        {id: 4, beds: 4,  selected: false, price: 12, title: "Single"},
        {id: 5, beds: 2,  selected: false, price: 12, title: "Single"},
        {id: 6, beds: 4,  selected: false, price: 12, title: "Single"},
        {id: 7, beds: 4,  selected: false, price: 12, title: "Single"},
      ],
    }
  }, methods: {
    selectRoom(index: number) {
      this.roomList[index].selected=!this.roomList[index].selected;
      // todo maybe call view details? what about select then?
      console.log("select room with id: " + this.roomList[index].id + " and go to detail view");
    },
  },
  computed: {
    selectedRooms() {
      const selectedRooms = this.roomList.filter( (room) => {
        return room.selected;
      });
      return selectedRooms;
    }
  }
}
</script>

<style scoped>

</style>