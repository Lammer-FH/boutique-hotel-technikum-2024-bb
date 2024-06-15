<template>
  <ion-item>
    <ion-label>Pick date</ion-label>
    <ion-input
        value="{{ date | date: 'dd.MM.yyyy' }}"
        id="date"
        class="ion-text-end"
    ></ion-input>
    <ion-popover trigger="date" size="cover">
      <ng-template>
        <ion-datetime
            presentation="date"
            v-model="date"
        locale="sl-SI"
        ></ion-datetime>
      </ng-template>
    </ion-popover>
  </ion-item>
</template>

<script lang="ts">
import {IonDatetime} from "@ionic/vue";
import {defineComponent} from "vue";
export default {
  data() {
    return {
      date: new Date().toISOString(), // Initialize with today's date
    };
  },
};
</script>



<style scoped>
</style>