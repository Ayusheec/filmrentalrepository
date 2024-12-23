import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const AddFilm = () => {
  const [film, setFilm] = useState({
    title: "",
    description: "",
    releaseYear: "",
    rentalDuration: "",
    rentalRate: "",
    length: "",
    replacement_cost: "", // Added field
    rating: "G",
    specialFeatures: "",
  });

  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFilm({
      ...film,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // Send the new film data to the backend
      const response = await axios.post("http://localhost:8080/api/films/post", film);

      // On success, show a success message and reset the form
      alert("Film created successfully!");
      setFilm({
        title: "",
        description: "",
        releaseYear: "",
        rentalDuration: "",
        rentalRate: "",
        length: "",
        replacement_cost: "", // Reset the field
        rating: "G",
        specialFeatures: "",
      });

      navigate("/films");
    } catch (error) {
      console.error("Error creating film:", error);
      setError("Failed to create film.");
    }
  };

  return (
    <div className="container mt-5">
      <h1>Add New Film</h1>

      {/* Display error if any */}
      {error && <p style={{ color: "red" }}>{error}</p>}

      <form onSubmit={handleSubmit}>
        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="title" className="form-label">Title</label>
          </div>
          <div className="col-md-9">
            <input
              type="text"
              id="title"
              name="title"
              className="form-control"
              value={film.title}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="description" className="form-label">Description</label>
          </div>
          <div className="col-md-9">
            <textarea
              id="description"
              name="description"
              className="form-control"
              value={film.description}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="releaseYear" className="form-label">Release Year</label>
          </div>
          <div className="col-md-9">
            <input
              type="number"
              id="releaseYear"
              name="releaseYear"
              className="form-control"
              value={film.releaseYear}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="rentalDuration" className="form-label">Rental Duration</label>
          </div>
          <div className="col-md-9">
            <input
              type="number"
              id="rentalDuration"
              name="rentalDuration"
              className="form-control"
              value={film.rentalDuration}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="rentalRate" className="form-label">Rental Rate</label>
          </div>
          <div className="col-md-9">
            <input
              type="number"
              id="rentalRate"
              name="rentalRate"
              className="form-control"
              value={film.rentalRate}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="length" className="form-label">Length</label>
          </div>
          <div className="col-md-9">
            <input
              type="number"
              id="length"
              name="length"
              className="form-control"
              value={film.length}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="replacement_cost" className="form-label">Replacement Cost</label>
          </div>
          <div className="col-md-9">
            <input
              type="number"
              id="replacement_cost"
              name="replacement_cost"
              className="form-control"
              value={film.replacement_cost}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="rating" className="form-label">Rating</label>
          </div>
          <div className="col-md-9">
            <select
              id="rating"
              name="rating"
              className="form-control"
              value={film.rating}
              onChange={handleChange}
            >
              <option value="G">G</option>
              <option value="PG">PG</option>
              <option value="PG_13">PG-13</option>
              <option value="R">R</option>
              <option value="NC_17">NC-17</option>
            </select>
          </div>
        </div>

        <div className="row mb-3">
          <div className="col-md-3">
            <label htmlFor="specialFeatures" className="form-label">Special Features</label>
          </div>
          <div className="col-md-9">
            <select
              id="specialFeatures"
              name="specialFeatures"
              className="form-control"
              value={film.specialFeatures}
              onChange={handleChange}
            >
              <option value="">Select Special Features</option>
              <option value="Trailers">Trailers</option>
              <option value="Commentaries">Commentaries</option>
              <option value="Deleted Scenes">Deleted Scenes</option>
              <option value="Behind the Scenes">Behind the Scenes</option>
            </select>
          </div>
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
};

export default AddFilm;