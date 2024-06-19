import { defineStore } from 'pinia'
import axios from "axios";

interface RoomExtraState {
    id: string,
    roomId: number,
    extraId: number,
}

const apiUrl: string =  "http://localhost:8080/api/hotel/v1/room_extras";
export const useRoomExtraStore = defineStore({
    id: 'roomExtra',

    state: (): { roomExtras: any[] } => ({
        roomExtras: []
    }),
    getters: {
    },
    actions: {
        async fetchRoomExtrasForRoom(roomId: number) {
            try {
                const response = await axios.get<Array<RoomExtraState>>(`${apiUrl}/${roomId}`);
                const roomExtras = response.data
                this.roomExtras = roomExtras
                console.log(response.data)

                return response.data
            } catch (error) {
                console.error('Error fetching customer data:', error);
            }
        },
    },
})

