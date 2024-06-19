<script setup lang="ts">

import {IonPage} from "@ionic/vue";
</script>

<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
      </ion-toolbar>
    </ion-header>
  <ion-content>
    <div class="contact-info">
      <h2>Contact Us</h2>
      <p>If you have any questions or need assistance, feel free to reach out to us.</p>
      <ion-list>
        <ion-item>
          <ion-icon name="location-outline"></ion-icon>
          <ion-label>123 Main Street, City</ion-label>
        </ion-item>
        <ion-item>
          <ion-icon name="mail-outline"></ion-icon>
          <ion-label>info@hoteltechnikum.com</ion-label>
        </ion-item>
        <ion-item>
          <ion-icon name="call-outline"></ion-icon>
          <ion-label>+1 123-456-7890</ion-label>
        </ion-item>
      </ion-list>
    </div>
  </ion-content>
  </ion-page>
</template>

<style scoped>
.contact-info {
  text-align: center;
  padding: 20px;
  font-size: 16px;
}

h2 {
  font-size: 24px;
  color: #333;
  margin-bottom: 10px;
}

ion-list {
  --ion-item-background: transparent;
  --ion-item-text-color: #555;
  --ion-item-detail-color: #888;
}

</style>