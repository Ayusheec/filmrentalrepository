// import axios from "axios";

// // Base URL for your API (replace with your actual API base URL)
// const API_BASE_URL = "http://localhost:8080/api";  // Example URL, adjust it as needed

// // Method to fetch all rented films by a customer ID
// const fetchRentedFilmsByCustomer = (customerId) => {
//   return axios
//     .get(`${API_BASE_URL}/rentals/customer/${customerId}/films`)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error fetching rented films");
//     });
// };

// // Method to add a new rental
// const addRental = (rentalData) => {
//   return axios
//     .post(`${API_BASE_URL}/rentals/add`, rentalData)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error adding rental");
//     });
// };

// // Method to update a rental (e.g., update return date)
// const updateRental = (rentalId, updatedData) => {
//   return axios
//     .put(`${API_BASE_URL}/rentals/update/${rentalId}`, updatedData)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error updating rental");
//     });
// };

// // Method to fetch all rentals
// const fetchAllRentals = () => {
//   return axios
//     .get(`${API_BASE_URL}/rentals`)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error fetching rentals");
//     });
// };

// // Method to fetch a specific rental by its ID
// const fetchRentalById = (rentalId) => {
//   return axios
//     .get(`${API_BASE_URL}/rentals/${rentalId}`)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error fetching rental by ID");
//     });
// };

// // Method to calculate revenue for films by store
// const calculateRevenueByStore = (storeId) => {
//   return axios
//     .get(`${API_BASE_URL}/payment/revenue/films/store/${storeId}`)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error calculating revenue");
//     });
// };

// // Method to fetch top 10 rented films in a store
// const fetchTopTenRentedFilms = (storeId) => {
//   return axios
//     .get(`${API_BASE_URL}/rental/toptenfilms/store/${storeId}`)
//     .then((response) => response.data)
//     .catch((error) => {
//       throw new Error(error.response?.data?.message || "Error fetching top rented films");
//     });
// };

// // Export the service methods for use in your components
// export default {
//   fetchRentedFilmsByCustomer,
//   addRental,
//   updateRental,
//   fetchAllRentals,
//   fetchRentalById,
//   calculateRevenueByStore,
//   fetchTopTenRentedFilms,
// };



import axios from "axios";

const fetchRentedFilmsByCustomer = (customerId) => {
  return axios
    .get(`/api/rental/customer/${customerId}`)
    .then((response) => response.data)
    .catch((error) => {
      console.error("Error fetching rented films:", error);
      throw error;
    });
};

export default { fetchRentedFilmsByCustomer };
