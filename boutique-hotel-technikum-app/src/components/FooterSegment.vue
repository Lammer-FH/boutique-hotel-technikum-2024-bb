<template>
  <ion-footer>
    <ion-toolbar>
      <div class="footer-content">
        <div class="footer-links">
          <ion-button fill="clear" href="/about-us">About us</ion-button>
          <ion-button fill="clear" href="/contact">Contact</ion-button>
          <ion-button fill="clear" href="/location">Location</ion-button>
        </div>
        <p>&copy; Copyright Boutique-Technikum. All rights reserved.</p>
      </div>
    </ion-toolbar>
  </ion-footer>
</template>

<script>
export default {
  name: 'FooterSegment'
};
</script>

<style scoped>
.footer-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.footer-links ion-button {
  --background: transparent;
  color: #fff;
}

ion-footer {
  background-color: #000;
  color: #fff;
}

ion-toolbar {
  --padding-start: 0;
  --padding-end: 0;
  --padding-top: 0;
  --padding-bottom: 0;
}

p {
  font-size: 0.8rem;
  margin-top: 10px;
}
</style>
