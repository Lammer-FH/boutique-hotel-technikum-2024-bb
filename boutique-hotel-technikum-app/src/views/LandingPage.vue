<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
            </ion-toolbar>
        </ion-header>
        <ion-content >
            <LandingTemplate />
        </ion-content>
    </ion-page>
</template>

<script>
import LandingTemplate from "@/components/LandingTemplate.vue";
export default {
  name: 'LandingPage',
  components: {
    LandingTemplate
  }
}
</script>