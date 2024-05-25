<script>

export default {
  name: 'RoomDetails',
  props: ["roomObject"],
  data() {
    return {
      room: this.roomObject
    }
  },
  methods: {}
}
</script>

<template>
  <div class="flex justify-between py-2 px-2 items-center">
    <p>Id: {{room.id}}</p>
    <p>Number of beds: {{ room.beds}}</p>
    <button class="bg-green-300 py-1 px-1 rounded">book room</button>
  </div>
</template>