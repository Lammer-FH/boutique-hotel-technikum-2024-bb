<template>
  <ion-item class="text-style" >
    <ion-label class="mr-1">{{dateModel.label}}</ion-label>
    <ion-input alternative
        class="custom-input"
        name="startdate"
        :rules="{required: true}"
        prepend-icon="ni ni-lock-circle-open"
        type="date"
        :value="dateModel.date"
        @ionInput="dateModel.date = $event.target.value"
    >
      <ion-popover trigger="date" size="cover">
        <ng-template>
          <ion-datetime
              presentation="date"
              v-model="date"
              locale="sl-SI"
          ></ion-datetime>
        </ng-template>
      </ion-popover>
    </ion-input>
  </ion-item>
</template>

<script lang="ts">

export default {
  props: ["dateModel"],
  data() {
    return {
      date: new Date().toISOString(),
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