import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api";
const API_FILM_URL = `${API_BASE_URL}/films`;

// Fetch all films
const fetchAll = async () => {
  try {
    const response = await axios.get(`${API_FILM_URL}/fetchall`);
    return response.data;
  } catch (error) {
    console.error("Error in fetchAll:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Add a new film
const addFilm = async (film) => {
  try {
    const response = await axios.post(`${API_FILM_URL}/post`, film);
    return response.data;
  } catch (error) {
    console.error("Error in addFilm:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Find film by title
const fetchByTitle = async (title) => {
  if (!title.trim()) {
    // If title is empty, return a custom error
    throw new Error("Please enter a title to search.");
  }

  try {
    const response = await axios.get(`${API_FILM_URL}/title/${title}`);
    return response.data;
  } catch (error) {
    console.error("Error in fetchByTitle:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Update a film
const updateFilm = async (filmId, updateFields) => {
  if (!filmId || !updateFields) {
    throw new Error("Film ID and update fields are required.");
  }
  if (!updateFields.rentalDuration || !updateFields.rentalRate || !updateFields.rating) {
    throw new Error("Rental duration, rental rate, and rating are required.");
  }

  try {
    const response = await axios.put(`${API_FILM_URL}/update/details/${filmId}`, updateFields);
    console.log("Film updated successfully:", response.data);
    return response.data;
  } catch (error) {
    console.error("Error updating film:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Delete a film
const deleteFilm = async (id) => {
  try {
    const response = await axios.delete(`${API_FILM_URL}/${id}`);
    console.log("Film deleted successfully:", response.data);
    return response.data; // Return a success message or any data
  } catch (error) {
    console.error("Error deleting film:", error);
    throw new Error(error.response ? error.response.data : error.message);
  }
};

// Export the methods
const filmService = {
  fetchAll,
  addFilm,
  fetchByTitle,
  updateFilm,
  deleteFilm,
};

export default filmService;