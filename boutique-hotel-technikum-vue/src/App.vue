<template>
  <div class="bg-gray-600 text-white w-1/2 m-auto">
    <div class="text-center border-b-2 border-black py-4">
      <h1 class="text-3xl py-4">All Rooms</h1>
    </div>
    <HelloWorld msg="Welcome to Hotel Boutique!"/>
    <br><br><br>

    <p>Verfügbare Zimmer: {{ zimmerListe.length}}</p>
    <div v-for="room in zimmerListe" :key="room.id">
      <RoomDetails :roomObject="room" ></RoomDetails>
    </div>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import RoomDetails from "@/components/RoomDetails.vue";

export default {
  name: 'App',
  components: {
    RoomDetails,
    HelloWorld
  },
  data() {
    return {
      zimmerListe: [
        {id: 1, beds: 4},
        {id: 2, beds: 2},
        {id: 3, beds: 3},
        {id: 4, beds: 4},
        {id: 5, beds: 2},
        {id: 6, beds: 41},
        {id: 7, beds: 41},
      ]
    }
  }
}
</script>

