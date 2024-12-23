import React, { useState } from "react";
import actorService from "../service/actorService";
 
const ActorTable = () => {
  const [actors, setActors] = useState([]);
 
  console.log("data ", actors)
  const fetchAllActors = async () => {
    try {
      const response = await actorService.fetchAllActors();
      setActors(response.data || []);
    } catch (error) {
      console.error("Error fetching actors:", error);
      alert("Failed to fetch actors.");
    }
  };
  return (
    <div>
      <h2 className="mb-4">All Actors</h2>
      <button className="btn btn-primary mb-4" onClick={fetchAllActors}>
        Fetch All Actors
      </button>
 
      <div style={{ maxHeight: "400px", overflowY: "auto" }}>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>Actor ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Last Update</th>
            </tr>
          </thead>
          <tbody>
            {actors.length > 0 ? (
              actors.map((actor) => (
                <tr key={actor.actor_id}>
                  <td>{actor.actor_id}</td>
                  <td>{actor.firstName}</td>
                  <td>{actor.lastName}</td>
                  <td>{actor.lastUpdate}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="4" className="text-center">
                  No actors found.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};
 
export default ActorTable;