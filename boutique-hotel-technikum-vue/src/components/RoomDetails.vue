<script>

export default {
  name: 'RoomDetails',
  props: ["roomObject", "roomIndex"],
  data() {
    return {
      roomEntity: this.roomObject
    }
  },
  methods: {
    toggleId() {
      this.$emit("roomEntity-index", this.roomIndex)
    },
    selectRoom() {
      this.$emit("selectroom-index", this.roomIndex)
    }
  }
}
</script>

<template>
  <div class="flex justify-between py-2 px-2 items-center cursor-pointer"
       :class="{'bg-green-600': this.roomEntity.selected}"
        @click="toggleId">
    <p>Id: {{roomEntity.id}}</p>
    <p>Number of beds: {{ roomEntity.beds}}</p>
    <p>Clicked: {{roomEntity.clicked}}</p>
    <button class="bg-green-300 py-1 px-1 rounded " @click="selectRoom">select roomEntity</button>
  </div>
</template>