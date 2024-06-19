import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import PaymentPage from '@/views/PaymentPage.vue';
import LandingPage from '@/views/LandingPage.vue';
import SearchRoomsPage from "@/views/SearchRoomsPage.vue";
import SingleRoomPage from "@/views/SingleRoomPage.vue";
import BookingConfirmationPage from "@/views/BookingConfirmationPage.vue";
import ContactPage from "@/views/ContactPage.vue";
import AboutUsPage from "@/views/AboutUsPage.vue";



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
    path: '/booking-confirmation',
    name: 'BookingConfirmation',
    component: BookingConfirmationPage,
    meta: {title: 'Booking Confirmation'}
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
  },
    {
        path: '/booking',
        name: 'Booking Confirmation',
        component: BookingConfirmationPage,
        meta: {title: 'Booking Confirmation'}
    },
  {
    path: '/contact',
    name: 'Contact',
    component: ContactPage,
    meta: {title: 'Contact'}
  },
  {
    path: '/about-us',
    name: 'About Us',
    component: AboutUsPage,
    meta: {title: 'About Us'}
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
