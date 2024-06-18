import { defineStore } from 'pinia'
import axios from "axios";

// Define the state interface
interface ExtraTypeState {
    id: number;
    title: string;
    description: string;
}

const apiUrl: string =  "http://localhost:8080/api/hotel/v1/extra_types";
export const useExtraTypeStore = defineStore({
    id: 'extraType',

    state: (): ExtraTypeState => ({
        id: 0,
        title: "Testuser",
        description: "Testuser"
    }),
    getters: {
    },
    actions: {
        async getExtraType(extraTypeId: number) {
            try {
                const response = await axios.get<ExtraTypeState>(`${apiUrl}/${extraTypeId}`);
                const extraType = response.data;
                console.log(extraType)
                this.id = extraType.id;
                this.title = extraType.title;
                this.description = extraType.description;
                return extraType;
            } catch (error) {
                console.error('Error fetching customer data:', error);
            }
        },
    },
})

