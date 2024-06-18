<template>
  <SearchForRoomsCard @search-for-rooms="searchForRooms" :search-model="searchModel"></SearchForRoomsCard>
  <ListOfRooms :room-list="roomList" @goToDetails="goToRoomDetails"></ListOfRooms>
</template>

<script lang="ts">
import {useRoomsStore} from "@/stores/room";
import {ref} from "vue";
import SearchForRoomsCard from "@/components/organisms/SearchForRoomsCard.vue";
import ListOfRooms from "@/components/organisms/ListOfRooms.vue";
import {useRouter} from "vue-router";

export default {
  components: {ListOfRooms, SearchForRoomsCard},
  setup() {
    const router = useRouter();

    async function goToDetails(id: number, start: string, end: string) {
      await router.push({ name: 'Room', query: { id: id, start: start, end: end } });
    }

    return {
      goToDetails
    }
  },
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
    goToRoomDetails(id: number){
      console.log("go to router");
      this.goToDetails(id, this.searchModel.startDateModel.date, this.searchModel.endDateModel.date);
    }
  },
}
</script>

<style scoped>

</style>