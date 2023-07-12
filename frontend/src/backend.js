import axios from "axios";
const baseUrl = 'http://localhost:8080'; // Replace with your actual backend URL

export const backend = {
    getWagons: async () => {
        try {
            const response = await axios.get(`${baseUrl}/wagons`);
            return response.data;
        } catch (error) {
            console.error('Error fetching wagons:', error);
            throw error;
        }
    },

    addWagon: async (wagon) => {
        try {
            const response = await axios.post(`${baseUrl}/add`, wagon);
            return response.data;
        } catch (error) {
            console.error('Error adding wagon:', error);
            throw error;
        }
    },

    getWagonById: async (id) => {
        try {
            const response = await axios.get(`${baseUrl}/wagon/${id}`);
            return response.data;
        } catch (error) {
            console.error(`Error fetching wagon with ID ${id}:`, error);
            throw error;
        }
    },

    updateWagon: async (id, updatedWagon) => {
        try {
            const response = await axios.put(`${baseUrl}/edit/${id}`, updatedWagon);
            return response.data;
        } catch (error) {
            console.error(`Error updating wagon with ID ${id}:`, error);
            throw error;
        }
    },

    deleteWagon: async (id) => {
        try {
            await axios.delete(`${baseUrl}/delete/${id}`);
        } catch (error) {
            console.error(`Error deleting wagon with ID ${id}:`, error);
            throw error;
        }
    },
};


