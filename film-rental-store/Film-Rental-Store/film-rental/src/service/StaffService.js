import axios from "axios";
 
const API_BASE_URL = "http://localhost:8080/api";
 
// Fetch all staff
const fetchAll = async () => {
  const response = await fetch(`${API_BASE_URL}/staff/fetchall`);
  if (!response.ok) {
    throw new Error("Failed to fetch staff.");
  }
  return response.json();
};
 
// Search staff by first name
const searchByFirstName = async (firstName) => {
  const response = await fetch(`${API_BASE_URL}/staff/first_name/${firstName}`);
  if (!response.ok) {
    throw new Error("Failed to search staff.");
  }
  return response.json();
};
 
 
// Export both methods
const staffService = {
  fetchAll,
  searchByFirstName,
};
 
export default staffService;