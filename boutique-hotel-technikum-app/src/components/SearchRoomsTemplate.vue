<template>
  <SearchForRoomsCard @search-for-rooms="searchForRooms" :search-model="searchModel"></SearchForRoomsCard>
  <ListOfRooms :room-list="roomList"></ListOfRooms>
</template>

<script lang="ts">
import RoomCard from "@/components/molecules/RoomCard.vue";
import {useRoomsStore} from "@/stores/room";
import {onMounted, ref} from "vue";
import SearchForRoomsCard from "@/components/organisms/SearchForRoomsCard.vue";
import ListOfRooms from "@/components/organisms/ListOfRooms.vue";

export default {
  components: {ListOfRooms, SearchForRoomsCard, RoomCard},
  data() {
    return {
      roomStore: useRoomsStore(),
      roomList: ref<any[]>([]),
      searchModel: {
        startDateModel: {
          label: 'Pick Start Date:',
          date: this.start || ''
        },
        endDateModel: {
          label: 'Pick End Date:',
          date: this.end || ''
        }
      }
    }
  },
  props: {
    start: String,
    end: String
  },
  mounted() {
    if(this.start && this.end) {
      this.searchForRooms(this.start, this.end);
    }
    else {
      this.searchForRooms('', '')
    }

  },
  methods: {
    async searchForRooms(start: string, end: string) {
      if(start === '' || end === ''){
        console.log("fetchrooms");
        await this.roomStore.fetchRooms();
        this.roomList = this.roomStore.rooms;
      }
      else {
        console.log("fetchRoomsByDates");
        await this.roomStore.fetchRoomsByDates(start, end);
        console.log(start),
          console.log(end)
        this.roomList = this.roomStore.rooms;
      }

    },
  },
}
</script>

<style scoped>

</style>