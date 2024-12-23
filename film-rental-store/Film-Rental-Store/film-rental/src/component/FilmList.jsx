import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import filmService from "../service/filmService";

const FilmList = () => {
  const [films, setFilms] = useState([]);
  const [error, setError] = useState(null);
  const [searchTitle, setSearchTitle] = useState("");
  const [isLoading, setIsLoading] = useState(true); // Track loading state
  const navigate = useNavigate();

  // Fetch all films initially when the component is mounted
  useEffect(() => {
    filmService
      .fetchAll()
      .then((data) => {
        if (Array.isArray(data)) {
          setFilms(data);
        } else {
          setError("Invalid response structure from the server.");
        }
      })
      .catch((err) => {
        setError(`Error fetching films: ${err.message}`);
      })
      .finally(() => setIsLoading(false)); // Set loading to false when done
  }, []);

  // Search films by title
  const handleSearchByTitle = () => {
    if (!searchTitle.trim()) {
      alert("Please enter a title to search.");
      setFilms([]); // Clear films if the search is empty
      return;
    }
    setIsLoading(true); // Start loading when search is triggered
    filmService
      .fetchByTitle(searchTitle)
      .then((data) => {
        if (Array.isArray(data) && data.length > 0) {
          setFilms(data);
          setError(null);
        } else {
          setFilms([]);
          setError("No films found with the specified title.");
        }
      })
      .catch((err) => {
        setError(`Error fetching films by title: ${err.message}`);
        setFilms([]); // Clear films if there is an error
      })
      .finally(() => setIsLoading(false)); // Set loading to false when done
  };

  // Navigate to the add film page
  const handleAddFilm = () => {
    navigate("/add-film");
  };

  // Handle rendering of film ratings
  const renderRating = (rating) => {
    return rating ? rating : "Not Rated"; // Default to "Not Rated" if rating is missing
  };

  // Handle film deletion
  const handleDeleteFilm = (filmId) => {
    const confirmed = window.confirm("Are you sure you want to delete this film?");
    if (confirmed) {
      filmService
        .deleteFilm(filmId)
        .then(() => {
          // Remove the deleted film from the state
          setFilms(films.filter((film) => film.film_id !== filmId));
        })
        .catch((err) => {
          setError(`Error deleting film: ${err.message}`);
        });
    }
  };

  return (
    <div className="container">
      {/* Navbar */}
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark shadow-lg mb-4">
        <div className="container-fluid">
          <a className="navbar-brand" href="/">
            Film Rental
          </a>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
                <div className="d-flex">
                  <input
                    type="text"
                    className="form-control me-2"
                    placeholder="Search by title"
                    value={searchTitle}
                    onChange={(e) => setSearchTitle(e.target.value)}
                  />
                  <button
                    className="btn btn-outline-success"
                    onClick={handleSearchByTitle}
                  >
                    Search
                  </button>
                </div>
              </li>
              <li className="nav-item">
                <Link to="/dashboard" className="nav-link">
                  <i className="bi bi-house-door-fill" title="Home"></i>
                </Link>
              </li>
              <li className="nav-item">
                <span
                  style={{ cursor: "pointer", color: "#f8f9fa" }}
                  onClick={handleAddFilm}
                  title="Add Film"
                >
                  <i className="bi bi-plus" style={{ fontSize: "1.5rem" }}></i>
                </span>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      {/* Film List */}
      <h1 className="mt-4 mb-4 text-center">Film List</h1>
      {error && <div className="alert alert-danger">{error}</div>}

      {/* Loading or No Films Found */}
      {isLoading ? (
        <div className="text-center">Loading films...</div>
      ) : films.length === 0 ? (
        <div className="text-center">No films to display.</div>
      ) : (
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Release Year</th>
              <th>Rating</th>
              <th>Actions</th>
              <th>Remove</th> {/* New Column */}
            </tr>
          </thead>
          <tbody>
            {films.map((film) => (
              <tr key={film.film_id}>
                <td>{film.title}</td>
                <td>{film.description}</td>
                <td>{film.releaseYear}</td>
                <td>{renderRating(film.rating)}</td>
                <td>
                  <button
                    className="btn btn-info btn-sm"
                    onClick={() => navigate(`/view-film/${film.film_id}`)}
                  >
                    View Details
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => handleDeleteFilm(film.film_id)}
                    title="Remove Film"
                  >
                    <i className="bi bi-trash" style={{ fontSize: "1.2rem" }}></i>
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default FilmList;
