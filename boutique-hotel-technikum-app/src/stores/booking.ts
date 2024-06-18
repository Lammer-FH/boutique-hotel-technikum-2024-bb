import { defineStore, acceptHMRUpdate } from 'pinia'
import { useUserStore } from './user'
import axios from "axios";
import {book} from "ionicons/icons";

// Define the state interface
interface BookingState {
    id: number;
    title: string;
    additionalNotes: string;
    customerId: number;
    roomId: number;
    createdAt: string;
    bookingStart: string,
    bookingEnd: string,
    breakfast: boolean,
    totalCost: number,
    cancelled: boolean
}

const apiUrl: string =  "http://localhost:8080/api/hotel/v1/booking";
export const useBookingStore = defineStore({
    id: 'booking',

    state: (): BookingState => ({
        id: 0,
        title: "string",
        additionalNotes: "string",
        customerId: 0,
        roomId: 0,
        createdAt: "string",
        bookingStart: "string",
        bookingEnd: "string",
        breakfast: false,
        totalCost: 0,
        cancelled: false
    }),
    getters: {
    },
    actions: {
        async createBooking(title: string,additionalNotes: string, customerId: number, roomId: number, bookingStart: string,bookingEnd: string,breakfast: boolean, totalCost: number) {
            try {
                const response = await axios.post<BookingState>(`${apiUrl}`,{
                    title: title,
                    additionalNotes: additionalNotes,
                    customerId: customerId,
                    roomId: roomId,
                    bookingStart: bookingStart,
                    bookingEnd: bookingEnd,
                    breakfast: breakfast,
                    totalCost: totalCost,

                });
                const booking = response.data;
                console.log(booking)
                this.id = booking.id;
                this.title = booking.title;
                this.additionalNotes = booking.additionalNotes;
                this.customerId = booking.customerId;
                this.roomId = booking.roomId;
                this.createdAt = booking.createdAt;
                this.bookingStart = booking.bookingStart;
                this.bookingEnd = booking.bookingEnd;
                this.breakfast = booking.breakfast;
                this.totalCost = booking.totalCost;
                this.cancelled = booking.cancelled;
                return booking
            } catch (error) {
                console.error('Error creating booking data:', error);
            }
        },
    },
})

