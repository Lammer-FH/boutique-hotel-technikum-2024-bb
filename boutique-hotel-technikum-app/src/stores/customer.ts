import { defineStore, acceptHMRUpdate } from 'pinia'
import { useUserStore } from './user'
import axios from "axios";

// Define the state interface
interface CustomerState {
    id: number;
    name: string;
    surname: string;
    email: string;
    phoneNumber: string;
    address: string;
}

const apiUrl: string =  "http://localhost:8080/api/hotel/v1/customer";
export const useCustomerStore = defineStore({
    id: 'customer',

    state: (): CustomerState => ({
        id: 1,
        name: "Testuser",
        surname: "Testuser",
        email: "Testuser",
        phoneNumber: "TestNumber",
        address: "TestStraße"
    }),
    getters: {
    },
    actions: {
        async readState(customerId: number) {
            try {
                const response = await axios.get<CustomerState>(`${apiUrl}/${customerId}`);
                const customer = response.data;
                console.log(response)
                this.id = customer.id;
                this.name = customer.name;
                this.surname = customer.surname;
                this.email = customer.email;
                this.phoneNumber = customer.phoneNumber;
                this.address = customer.address;
            } catch (error) {
                console.error('Error fetching customer data:', error);
            }
        },
        async createCustomer(name: string,surname: string, phoneNumber: string, address: string, email: string) {
            try {
                const response = await axios.post<CustomerState>(`${apiUrl}`,{
                    name: name,
                    surname: surname,
                    phonenumber: phoneNumber,
                    address: address,
                    email: email
                });
                const customer = response.data;
                console.log(response)
                this.id = customer.id;
                this.name = customer.name;
                this.surname = customer.surname;
                this.email = customer.email;
                this.phoneNumber = customer.phoneNumber;
                this.address = customer.address;
            } catch (error) {
                console.error('Error creating customer data:', error);
            }
        },
        async updateCustomer(customerId: number,name: string,surname: string, phoneNumber: string, address: string, email: string) {
            try {
                const response = await axios.put<CustomerState>(`${apiUrl}`,{
                    id: customerId,
                    name: name,
                    surname: surname,
                    phonenumber: phoneNumber,
                    address: address,
                    email: email
                });
                const customer = response.data;
                console.log(response)
                this.id = customer.id;
                this.name = customer.name;
                this.surname = customer.surname;
                this.email = customer.email;
                this.phoneNumber = customer.phoneNumber;
                this.address = customer.address;
            } catch (error) {
                console.error('Error updating customer data:', error);
            }
        }
    },
})

