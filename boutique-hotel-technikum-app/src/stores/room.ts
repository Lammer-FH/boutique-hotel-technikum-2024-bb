import { defineStore, acceptHMRUpdate } from 'pinia'
import axios from "axios";

interface RoomState {
    id: number,
    title: string,
    description: string,
    price: number,
    roomType: string,
    bedType: string,
    bedCount: number,
    image: string
}

const apiUrl: string =  "http://localhost:8080/api/hotel/v1/rooms";
export const useRoomsStore = defineStore({
    id: 'rooms',

    state: (): { rooms: any[] } => ({
        rooms: []
    }),
    getters: {
    },
    actions: {
        async fetchRooms() {
            try {
                const response = await axios.get<Array<RoomState>>(`${apiUrl}`);
                const rooms = response.data
                this.rooms = rooms
                console.log(response.data)

                return response.data
            } catch (error) {
                console.error('Error fetching customer data:', error);
            }
        },
        async fetchRoomById(roomId: number) {
            try {
                this.rooms=[]
                const response = await axios.get<RoomState>(`${apiUrl}/${roomId}`);
                const room = response.data
                this.rooms[0] = room
                console.log(room)

                return room
            } catch (error) {
                console.error('Error fetching customer data:', error);
            }
        },
        async fetchRoomsByDates(startDate: string, endDate: string) {
            try {
                this.rooms=[]
                const response = await axios.get<Array<RoomState>>(`${apiUrl}?start=${startDate}&end=${endDate}`);
                const rooms = response.data
                this.rooms = rooms
                console.log(response.data)

                return response.data
            } catch (error) {
                console.error('Error fetching customer data:', error);
            }
        },
    },
})

