import axios from "axios";

// Define the base URL for the API
const API_BASE_URL = "http://localhost:8080/api";
const API_CUSTOMER_URL=`${API_BASE_URL}/customers`;

// Fetch all customers
const fetchAllCustomers = async () => {
  try {
    const response = await axios.get(`${API_CUSTOMER_URL}/fetchall`);
    return response.data;
  } catch (error) {
    console.error("Error in fetchAll:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Fetch a specific customer by their ID
const fetchCustomerById = async (customerId) => {
    try {
      const response = await axios.get(`${API_CUSTOMER_URL}/find-by-id/${customerId}`);
      return response.data;
    } catch (error) {
      throw new Error(`Failed to fetch customer with ID ${customerId}. ${error.message}`);
    }
  };

  // Fetch a specific customer by their firstname
  const fetchByFirstName = async (firstName) => {
    try {
      const response = await axios.get(`http://localhost:8080/api/customers/firstname/${firstName}`);
      return response.data; // Return the customer list from the API
    } catch (error) {
      throw error; // Rethrow the error to handle it in the component
    }
  };
  

// Add a new customer(using axios)
const addCustomer = async (customer) => {
  return axios
    .post(`${API_CUSTOMER_URL}/post`, customer) // Corrected endpoint
    .then((response) => response.data)
    .catch((error) => {
      console.error("There was an error adding the customer:", error);
      throw new Error(error.response ? error.response.data : error.message);
    });
};

// Update an existing customer
const updateCustomer = (customerId, updatedCustomer) => {
  return axios
    .put(`${API_CUSTOMER_URL}/update/${customerId}`, updatedCustomer) // Ensure correct endpoint and data
    .then((response) => response.data)
    .catch((error) => {
      console.error("Error in updateCustomer:", error.response?.data || error.message);
      throw new Error(error.response?.data || "Failed to update customer");
    });
};

// Delete a customer
const deleteCustomer = async (customerId) => {
  try {
    const response = await axios.delete(`${API_CUSTOMER_URL}/${customerId}`);
    return response.data;  // Return the response data
  } catch (error) {
    console.error("There was an error deleting the customer:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Export all customer-related methods
const customerService = {
  fetchAllCustomers,
  fetchCustomerById,
  addCustomer,
  updateCustomer,
  fetchByFirstName,
  deleteCustomer
};

export default customerService;
