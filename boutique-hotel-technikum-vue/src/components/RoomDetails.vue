<script>

export default {
  name: 'RoomDetails',
  props: ["roomObject", "roomIndex"],
  data() {
    return {
      room: this.roomObject
    }
  },
  methods: {
    toggleId() {
      this.$emit("room-index", this.roomIndex)
    },
    selectRoom() {
      this.$emit("selectroom-index", this.roomIndex)
    }
  }
}
</script>

<template>
  <div class="flex justify-between py-2 px-2 items-center cursor-pointer"
       :class="{'bg-green-600': this.room.selected}"
        @click="toggleId">
    <p>Id: {{room.id}}</p>
    <p>Number of beds: {{ room.beds}}</p>
    <p>Clicked: {{room.clicked}}</p>
    <button class="bg-green-300 py-1 px-1 rounded " @click="selectRoom">select room</button>
  </div>
</template>