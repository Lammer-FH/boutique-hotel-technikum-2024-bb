<template>
  <SearchForRoomsCard></SearchForRoomsCard>
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
  setup() {
    const roomStore = useRoomsStore();
    const roomList = ref<[]>([]);

    onMounted(async () => {
      await roomStore.fetchRooms();
      roomList.value = roomStore.rooms;
    });
    console.log(roomList.value)
    return { roomList };
  },
  data() {
    return {
      // todo get actual room list
      roomStore: useRoomsStore(),
    }
  }
}
</script>

<style scoped>

</style>