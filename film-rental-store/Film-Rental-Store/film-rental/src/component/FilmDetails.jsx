import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import filmService from "../service/filmService";
import { FaEdit, FaArrowLeft } from "react-icons/fa"; // React Icons

const FilmDetails = () => {
  const { filmId } = useParams();
  const [film, setFilm] = useState(null);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    filmService
      .fetchAll()
      .then((data) => {
        const selectedFilm = data.find((film) => film.film_id === parseInt(filmId));
        if (selectedFilm) {
          setFilm(selectedFilm);
        } else {
          setError("Film not found.");
        }
      })
      .catch((err) => {
        setError(`Error fetching film details: ${err.message}`);
      });
  }, [filmId]);

  if (error) return <div className="alert alert-danger">{error}</div>;

  return (
    <div className="container mt-5">
      {film ? (
        <div className="card shadow-lg p-4 mb-4">
          <div className="card-header" style={{ backgroundColor: "#f8f9fa" }}> {/* Light grey background */}
  <h2>{film.title}</h2>
</div>

          <div className="card-body">
            <p>
              <strong>Description:</strong> {film.description}
            </p>
            <p>
              <strong>Release Year:</strong> {film.releaseYear}
            </p>
            <p>
              <strong>Rental Duration:</strong> {film.rentalDuration} days
            </p>
            <p>
              <strong>Rental Rate:</strong> <span className="text-success">${film.rentalRate}</span>
            </p>
            <p>
              <strong>Rating:</strong> {film.rating}
            </p>
            <p>
              <strong>Length:</strong> {film.length} minutes
            </p>
            <p>
              <strong>Replacement Cost:</strong> <span className="text-warning">${film.replacement_cost}</span>
            </p>
            <p>
              <strong>Special Features:</strong> {film.specialFeatures || "None"}
            </p>
            <div className="d-flex justify-content-between">
              {/* Edit button */}
              <button
                onClick={() => navigate(`/edit-film/${film.film_id}`)}
                className="btn btn-warning text-white"
              >
                <FaEdit /> Edit
              </button>

              {/* Back to Film List button */}
              <button
                onClick={() => navigate("/films")}
                className="btn btn-secondary"
              >
                <FaArrowLeft /> Back to Film List
              </button>
            </div>
          </div>
        </div>
      ) : (
        <div className="text-center">
          <div className="spinner-border text-primary" role="status">
            <span className="sr-only">Loading...</span>
          </div>
        </div>
      )}
    </div>
  );
};

export default FilmDetails;
