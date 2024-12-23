import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import rentalService from "../service/rentalService";

const RentedFilms = () => {
  const { id } = useParams();
  const [films, setFilms] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    rentalService
      .fetchRentedFilmsByCustomer(id)
      .then((data) => {
        console.log("Fetched rented films data:", data); // Check what data is returned
        if (Array.isArray(data)) {
          setFilms(data);
        } else {
          setError("The data received is not in the expected format.");
        }
      })
      .catch((err) => {
        console.error("Error fetching rented films:", err); // Log the error in console
        setError("Error fetching rented films");
      });
  }, [id]);

  if (error) {
    return <div style={{ color: "red", textAlign: "center" }}>{error}</div>;
  }

  if (films.length === 0) {
    return <div style={{ textAlign: "center" }}>No rented films found.</div>;
  }

  return (
    <div className="container mt-5">
      <h1 className="text-center">Rented Films</h1>
      <table className="table table-bordered mt-4">
        <thead>
          <tr>
            <th>Film Title</th>
            <th>Description</th>
            <th>Rental Date</th>
            <th>Return Date</th>
          </tr>
        </thead>
        <tbody>
          {Array.isArray(films) && films.map((rental) => (
            <tr key={rental.id}>
              <td>{rental.inventory.film.title}</td>
              <td>{rental.inventory.film.description}</td>
              <td>{new Date(rental.rentalDate).toLocaleString()}</td>
              <td>{rental.returnDate ? new Date(rental.returnDate).toLocaleString() : "Not Returned"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RentedFilms;
