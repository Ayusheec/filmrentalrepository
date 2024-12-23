import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import filmService from "../service/filmService";

const EditFilm = () => {
  const { filmId } = useParams();
  const [film, setFilm] = useState(null);
  const [updatedFilm, setUpdatedFilm] = useState({
    title: "",
    description: "",
    releaseYear: "",
    rentalDuration: "",
    rentalRate: "",
    rating: "",
    length: "",
    replacement_cost: "",
    specialFeatures: "",
  });
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    filmService
      .fetchAll()
      .then((data) => {
        const selectedFilm = data.find((film) => film.film_id === parseInt(filmId));
        if (selectedFilm) {
          setFilm(selectedFilm);
          setUpdatedFilm({
            title: selectedFilm.title || "",
            description: selectedFilm.description || "",
            releaseYear: selectedFilm.releaseYear || "",
            rentalDuration: selectedFilm.rentalDuration || "",
            rentalRate: selectedFilm.rentalRate || "",
            rating: selectedFilm.rating || "",
            length: selectedFilm.length || "",
            replacement_cost: selectedFilm.replacement_cost || "",
            specialFeatures: selectedFilm.specialFeatures || "",
          });
        } else {
          setError("Film not found.");
        }
      })
      .catch((err) => {
        setError(`Error fetching film details: ${err.message}`);
      });
  }, [filmId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUpdatedFilm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSave = () => {
    const { title, description, releaseYear, rentalDuration, rentalRate, rating, length, replacement_cost, specialFeatures } = updatedFilm;

    if (!title || !description || !releaseYear || !rentalDuration || !rentalRate || !rating || !length || !replacement_cost || !specialFeatures) {
      window.alert("All fields are required. Please fill in all fields.");
      return;
    }

    const payload = {
      title,
      description,
      releaseYear: parseInt(releaseYear, 10),
      rentalDuration: parseInt(rentalDuration, 10),
      rentalRate: parseFloat(rentalRate),
      rating,
      length: parseInt(length, 10),
      replacement_cost: parseFloat(replacement_cost),
      specialFeatures,
    };

    filmService
      .updateFilm(filmId, payload)
      .then(() => {
        window.alert("Film updated successfully!");
        navigate(`/view-film/${filmId}`);
      })
      .catch((err) => {
        setError(`Error updating film: ${err.message}`);
      });
  };

  if (error) return <div className="alert alert-danger text-center">{error}</div>;

  return (
    <div className="container my-5">
      {film ? (
        <div className="card shadow-lg p-4">
          <h2 className="text-center mb-4">Edit Film</h2>
          <form>
            <div className="mb-3">
              <label className="form-label">Title</label>
              <input
                type="text"
                className="form-control"
                name="title"
                placeholder="Enter film title"
                value={updatedFilm.title}
                onChange={handleChange}
              />
            </div>
            <div className="mb-3">
              <label className="form-label">Description</label>
              <textarea
                className="form-control"
                name="description"
                placeholder="Enter film description"
                value={updatedFilm.description}
                onChange={handleChange}
              />
            </div>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label className="form-label">Release Year</label>
                <input
                  type="number"
                  className="form-control"
                  name="releaseYear"
                  placeholder="Enter release year"
                  value={updatedFilm.releaseYear}
                  onChange={handleChange}
                />
              </div>
              <div className="col-md-6 mb-3">
                <label className="form-label">Rental Duration (days)</label>
                <input
                  type="number"
                  className="form-control"
                  name="rentalDuration"
                  placeholder="Enter rental duration"
                  value={updatedFilm.rentalDuration}
                  onChange={handleChange}
                />
              </div>
            </div>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label className="form-label">Rental Rate (USD)</label>
                <input
                  type="number"
                  className="form-control"
                  name="rentalRate"
                  placeholder="Enter rental rate"
                  value={updatedFilm.rentalRate}
                  onChange={handleChange}
                />
              </div>
              <div className="col-md-6 mb-3">
                <label className="form-label">Length (minutes)</label>
                <input
                  type="number"
                  className="form-control"
                  name="length"
                  placeholder="Enter film length"
                  value={updatedFilm.length}
                  onChange={handleChange}
                />
              </div>
            </div>
            <div className="mb-3">
              <label className="form-label">Rating</label>
              <select
                className="form-select"
                name="rating"
                value={updatedFilm.rating}
                onChange={handleChange}
              >
                <option value="">Select rating</option>
                <option value="G">G</option>
                <option value="PG">PG</option>
                <option value="PG_13">PG-13</option>
                <option value="R">R</option>
                <option value="NC_17">NC-17</option>
              </select>
            </div>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label className="form-label">Replacement Cost (USD)</label>
                <input
                  type="number"
                  className="form-control"
                  name="replacement_cost"
                  placeholder="Enter replacement cost"
                  value={updatedFilm.replacement_cost}
                  onChange={handleChange}
                />
              </div>
              <div className="col-md-6 mb-3">
                <label className="form-label">Special Features</label>
                <textarea
                  className="form-control"
                  name="specialFeatures"
                  placeholder="Enter special features"
                  value={updatedFilm.specialFeatures}
                  onChange={handleChange}
                />
              </div>
            </div>
            <div className="d-flex justify-content-between">
              <button type="button" onClick={handleSave} className="btn btn-success">
                Save Changes
              </button>
              <button
                type="button"
                onClick={() => navigate(`/`)}
                className="btn btn-secondary"
              >
                Cancel
              </button>
              <button
                type="button"
                onClick={() => navigate("/")}
                className="btn btn-danger"
              >
                Back to Home
              </button>
            </div>
          </form>
        </div>
      ) : (
        <div className="text-center">
          <div className="spinner-border text-primary" role="status">
            <span className="visually-hidden">Loading...</span>
          </div>
        </div>
      )}
    </div>
  );
};

export default EditFilm;