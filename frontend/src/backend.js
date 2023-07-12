import axios from 'axios';

const BASE_URL = 'http://localhost:8080'; // Replace with your backend server URL

// Retrieve all wagons
export const getWagons = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/wagons`);
        return response.data;
    } catch (error) {
        console.error('Error retrieving wagons:', error);
        throw error;
    }
};

// Add a new wagon
export const addWagon = async (wagon) => {
    try {
        const response = await axios.post(`${BASE_URL}/add`, wagon);
        return response.data;
    } catch (error) {
        console.error('Error adding wagon:', error);
        throw error;
    }
};

// Retrieve a wagon by ID
export const getWagonById = async (id) => {
    try {
        const response = await axios.get(`${BASE_URL}/wagon/${id}`);
        return response.data;
    } catch (error) {
        console.error(`Error retrieving wagon with ID ${id}:`, error);
        throw error;
    }
};

// Update a wagon by ID
export const updateWagon = async (id, updatedWagon) => {
    try {
        const response = await axios.put(`${BASE_URL}/edit/${id}`, updatedWagon);
        return response.data;
    } catch (error) {
        console.error(`Error updating wagon with ID ${id}:`, error);
        throw error;
    }
};

// Delete a wagon by ID
export const deleteWagon = async (id) => {
    try {
        await axios.delete(`${BASE_URL}/delete/${id}`);
    } catch (error) {
        console.error(`Error deleting wagon with ID ${id}:`, error);
        throw error;
    }
};
