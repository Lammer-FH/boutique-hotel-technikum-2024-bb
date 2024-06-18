<template>
  <div v-if="roomList.length > 0" v-for="(room, index) in roomList" :key="room.id">
    <RoomCard :roomObject="room" :roomIndex="index" @selectroom="selectRoom"></RoomCard>
  </div>
  <p v-else>Keine Zimmer Verfügbar</p>
</template>

<script lang="ts">
import RoomCard from "@/components/molecules/RoomCard.vue";
import {useRoomsStore} from "@/stores/room";
import {onMounted, ref} from "vue";

export default {
  name: 'ListOfRooms',
  components: {RoomCard},
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
  }, methods: {
    selectRoom(index: number) {
      // todo maybe call view details? what about select then?
      console.log("select room with id: " + this.roomList[index].id + " and go to detail view");
    },
  },
}
</script>

<style scoped>

</style>