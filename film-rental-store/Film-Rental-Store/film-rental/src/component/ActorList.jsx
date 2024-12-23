import React, { useState } from "react";
import actorService from "../service/actorService";
 
const ActorList = () => {
  const [actors, setActors] = useState([]);
  const [searchType, setSearchType] = useState("firstName");
  const [query, setQuery] = useState("");
 
  const fetchActors = async () => {
    try {
      const response =
        searchType === "firstName"
          ? await actorService.getActorsByFirstName(query)
          : await actorService.getActorsByLastName(query);
      setActors(response.data || []);
    } catch (error) {
      alert("Failed to fetch actors. Please try again.");
      console.error("Error fetching actors:", error);
    }
  };
 
  return (
    <div className="container mt-5">
      <h2 className="mb-4">Search Actors</h2>
      <div className="row mb-3">
        <div className="col-md-4">
          <label htmlFor="searchType" className="form-label">
            Search by:
          </label>
          <select
            className="form-select"
            id="searchType"
            value={searchType}
            onChange={(e) => setSearchType(e.target.value)}
          >
            <option value="firstName">First Name</option>
            <option value="lastName">Last Name</option>
          </select>
        </div>
        <div className="col-md-6">
          <label htmlFor="query" className="form-label">
            Search Term:
          </label>
          <input
            type="text"
            className="form-control"
            id="query"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            placeholder="Enter search term"
          />
        </div>
        <div className="col-md-2 d-flex align-items-end">
          <button className="btn btn-primary w-100" onClick={fetchActors}>
            Search
          </button>
        </div>
      </div>
      <ul className="list-group">
        {actors.map((actor) => (
          <li key={actor.actor_id} className="list-group-item">
            {actor.firstName} {actor.lastName}
          </li>
        ))}
      </ul>
    </div>
  );
};
 
export default ActorList;