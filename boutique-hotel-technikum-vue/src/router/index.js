
import {createRouter, createWebHistory} from 'vue-router';
import AboutView from "@/views/AboutView.vue";
import RoomsView from "@/views/RoomsView.vue";
import HomeView from "@/views/HomeView.vue";

export let router =  createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Home',
            component: HomeView
        },
        {
            path: '/about',
            name: 'About',
            component: AboutView
        },
        {
            path: '/rooms',
            name: 'Rooms',
            component: RoomsView
        }
    ]
});
