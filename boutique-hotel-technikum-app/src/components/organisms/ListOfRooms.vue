<template>
  <div v-if="paginatedRooms.length > 0" v-for="(room, index) in paginatedRooms" :key="room.id">
    <RoomCard :roomObject="room" :roomIndex="index" @selectroom="selectRoom"></RoomCard>
  </div>
  <p v-else>Keine Zimmer Verfügbar</p>
  <ion-button @click="prevPage" :disabled="currentPage <= 1">Previous</ion-button>
  <ion-button @click="nextPage" :disabled="currentPage * pageSize >= roomList.length">Next</ion-button>
</template>

<script lang="ts">
import RoomCard from "@/components/molecules/RoomCard.vue";

export default {
  name: 'ListOfRooms',
  components: {RoomCard},
  props: ["roomList"],
  data() {
    return {
      // ... other data properties ...
      currentPage: 1,
      pageSize: 5,
    }
  },
  methods: {
    selectRoom(index: number) {
      // todo maybe call view details? what about select then?
      console.log("select room with id: " + this.roomList[index].id + " and go to detail view");
    },
    nextPage() {
      if (this.currentPage * this.pageSize < this.roomList.length) {
        this.currentPage++;
      }
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
  },

  computed: {
    paginatedRooms() {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = start + this.pageSize;
      return this.roomList.slice(start, end);
    }
  },

}
</script>

<style scoped>

</style>