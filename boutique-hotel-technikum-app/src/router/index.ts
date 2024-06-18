import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import PaymentPage from '@/views/PaymentPage.vue';
import LandingPage from '@/views/LandingPage.vue';
import SearchRoomsPage from "@/views/SearchRoomsPage.vue";
import SingleRoomPage from "@/views/SingleRoomPage.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/welcome'
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
    path: '/search',
    name: 'Search',
    component: SearchRoomsPage,
    meta: {title: 'Search'}
  },
  {
    path: '/room',
    name: 'Room',
    component: SingleRoomPage,
    meta: {title: 'Room Details'}
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
