import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue'
import PaymentPage from '../views/PaymentPage.vue'
import BookingConfirmationPage from '../views/BookingConfirmationPage.vue'
import LandingPage from "../views/LandingPage.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/welcome'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/payment',
    name: 'Payment',
    component: PaymentPage,
    meta: {title: 'Payment Details'}
  },
  {
    path: '/welcome',
    name: 'Welcome',
    component: LandingPage,
    meta: {title: 'Welcome'}
  },
    {
        path: '/booking-confirmation',
        name: 'BookingConfirmation',
        component: BookingConfirmationPage
    }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
