import React, { useState } from "react";
import actorService from "../service/actorService";
 
const ActorFilms = () => {
  const [actorId, setActorId] = useState("");
  const [films, setFilms] = useState([]);
 
  const fetchFilms = async () => {
    try {
      const response = await actorService.getFilmsByActorId(actorId);
      setFilms(response.data || []);
    } catch (error) {
      console.error("Error fetching films:", error);
      alert("Failed to fetch films. Please check the actor ID and try again.");
    }
  };
 
  return (
    <div className="container mt-5">
      <h2 className="mb-4">Get Films by Actor</h2>
      <div className="mb-3">
        <label htmlFor="actorId" className="form-label">
          Actor ID:
        </label>
        <input
          type="text"
          className="form-control"
          id="actorId"
          value={actorId}
          onChange={(e) => setActorId(e.target.value)}
        />
      </div>
      <button className="btn btn-primary mb-4" onClick={fetchFilms}>
        Fetch Films
      </button>
      <ul className="list-group">
        {films.map((film, index) => (
          <li key={index} className="list-group-item">
            {film.title}
          </li>
        ))}
      </ul>
    </div>
  );
};
 
export default ActorFilms;