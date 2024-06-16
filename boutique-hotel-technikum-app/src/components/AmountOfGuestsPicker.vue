<template>
  <ion-item >
    <p class="text-style mr-2">Guests: {{numberOfGuests}}</p>
    <ion-button class="width" shape="round" v-on:click="updateNumberOfGuests(-1)"> - </ion-button>
    <ion-button class="width" shape="round" v-on:click="updateNumberOfGuests(1)"> + </ion-button>
  </ion-item>
</template>

<script lang="ts">
export default {
  name: 'AmountOfGuestsPicker',
  props: ["numberOfGuests"],
  methods: {
    updateNumberOfGuests(change: number) {
      // todo WHY IS IT READONLY?????????? CANNOT USE V-MODEL WTF
      if(this.numberOfGuests + change >= 0){
        this.$emit("updateNumberOfGuests", this.numberOfGuests + change);
      }
    }
  }
}
</script>

<style scoped>
p.text-style {
  font-size: 1rem;
}
p.mr-2 {
  margin-right: 1rem;
}
ion-button.width {
  width: 2rem;
}
</style>