<template>
  <div>
    <NavigationBar/>
    <router-view/>
  </div>
  <div class="bg-gray-600 text-white w-1/2 m-auto">
    <div class="text-center border-b-2 border-black py-4">
      <h1 class="text-3xl py-4">All Rooms</h1>
    </div>
    <HelloWorld msg="Welcome to Hotel Boutique!"/>
    <br><br><br>
    <div class="mt-4">
      <p>Name: </p>
      <input type="text" class="py-2 w-2/3 text-green-600" v-model="customerName"/>
      <button class="bg-green-300 py-1 px-1 rounded " @click="bookRoom(customerName)">book roomEntity</button>
    </div>


    <br><br><br>
    <p>Verfügbare Zimmer: {{ zimmerListe.length}}</p>
    <p v-if="selectedRooms.length > 0">Selected Zimmer: {{ selectedRooms.length}}</p>
    <p v-else>Keine Zimmer Selected</p>
    <div v-for="(roomEntity, index) in zimmerListe" :key="roomEntity.id">
      <RoomDetails :roomObject="roomEntity" :roomIndex="index" @roomEntity-index="toggleId" @selectroom-index="selectRoom"></RoomDetails>
    </div>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import RoomDetails from "@/components/RoomDetails.vue";
import NavigationBar from "@/components/NavigationBar.vue";

export default {
  name: 'App',
  components: {
    NavigationBar,
    RoomDetails,
    HelloWorld
  },
  data() {
    return {
      zimmerListe: [
        {id: 1, beds: 4, clicked: 0, selected: false},
        {id: 2, beds: 2, clicked: 0, selected: false},
        {id: 3, beds: 3, clicked: 0, selected: false},
        {id: 4, beds: 4, clicked: 0, selected: false},
        {id: 5, beds: 2, clicked: 0, selected: false},
        {id: 6, beds: 4, clicked: 0, selected: false},
        {id: 7, beds: 4, clicked: 0, selected: false},
      ],
      customerName: "",
    }
  }, methods: {
    toggleId(index) {
      this.zimmerListe[index].clicked++;
    },
    selectRoom(index) {
      this.zimmerListe[index].selected=!this.zimmerListe[index].selected;
    },
    bookRoom(customerName) {
      if(this.customerName.trim() === ""){
        return;
      }
      console.log("roomEntity booked for customerEntity " + customerName);
    }
  },
  computed: {
    selectedRooms() {
      const selectedRooms = this.zimmerListe.filter( (roomEntity) => {
        return roomEntity.selected;
      });
      return selectedRooms;
    }
  }
}
</script>

