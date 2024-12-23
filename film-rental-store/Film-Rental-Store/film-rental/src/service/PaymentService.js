import axios from 'axios';
 
// Base URL for the backend API
const API_BASE_URL = 'http://localhost:8080/api/payment'; // Update the URL if your backend is running on a different host or port
 
 
 
// Function to get cumulative revenue by date
export const getCumulativeRevenueByDate = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/revenue/datewise`);
        return response.data; // List of payment data by date
    } catch (error) {
        console.error('Error fetching cumulative revenue by date:', error);
        throw error;
    }
};
 
// Function to get revenue by store
export const getRevenueByStore = async (storeId) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/datewise/store/${storeId}`);
        return response.data; // Revenue data for the store
    } catch (error) {
        console.error('Error fetching revenue by store:', error);
        throw error;
    }
};
 
// Function to get filmwise revenue
export const getFilmwiseRevenue = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/revenue/filmwise`);
        return response.data; // Filmwise revenue data
    } catch (error) {
        console.error('Error fetching filmwise revenue:', error);
        throw error;
    }
};
 
 
 
// Function to get cumulative revenue by store
export const getCumulativeRevenueByStore = async (storeId) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/revenue/films/store/${storeId}`);
        return response.data; // Cumulative revenue by store
    } catch (error) {
        console.error('Error fetching cumulative revenue by store:', error);
        throw error;
    }
};