<template>
  <ion-item class="text-style" >
    <ion-label class="mr-1">Pick start date</ion-label>
    <ion-input alternative
        class="custom-input"
        name="startdate"
        :rules="{required: true}"
        prepend-icon="ni ni-lock-circle-open"
        type="date"
        :value="searchModel.startDate"
        @ionInput="searchModel.startDate = $event.target.value"
    >
    <ion-popover trigger="date" size="cover">
      <ng-template>
        <ion-datetime
            presentation="date"
            v-model="date"
            locale="sl-SI"
        ></ion-datetime>
      </ng-template>
    </ion-popover></ion-input>
  </ion-item>
  <ion-item class="text-style">
    <ion-label class="mr-1">Pick end date</ion-label>
    <ion-input alternative
               class="custom-input"
               name="enddate"
               :rules="{required: true}"
               prepend-icon="ni ni-lock-circle-open"
               type="date"
               :value="searchModel.endDate"
               @ionInput="searchModel.endDate = $event.target.value"
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
import { IonInput, IonItem, IonList } from '@ionic/vue';
export default {
  props: ["searchModel"],
  data() {
    return {
      date: new Date().toISOString(), // Initialize with today's date
      //dateFormat: "dd.MM.yyyy",
    };
  },

};
</script>



<style scoped>
/* Add custom styling for the label */
ion-label.mr-1 {
  margin-right: 1rem; /* Adjust the spacing as needed */
}

ion-input.custom-input {
  width: 50%;
}

ion-item.text-style {
  font-size: 1rem;
}
</style>