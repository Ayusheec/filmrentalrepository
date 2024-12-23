import React, { useState } from "react";
import actorService from "../service/actorService";
 
const ActorForm = () => {
  const [actor, setActor] = useState({
    firstName: "",
    lastName: "",
    lastUpdate: ""
 
  });
 
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await actorService.addActor(actor);
      alert("Actor added successfully!");
      setActor({ firstName: "", lastName: "", lastUpdate: new Date().toISOString() });
    } catch (error) {
      console.error("Error adding actor:", error);
      alert("Failed to add actor. Please try again.");
    }
  };
 
  const handleChange = (e) => {
    const { name, value } = e.target;
    setActor({ ...actor, [name]: value });
  };
 
  return (
    <div className="container mt-5">
      <h2 className="mb-4">Add Actor</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="firstName" className="form-label">
            First Name:
          </label>
          <input
            type="text"
            className="form-control"
            id="firstName"
            name="firstName"
            value={actor.firstName}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="lastName" className="form-label">
            Last Name:
          </label>
          <input
            type="text"
            className="form-control"
            id="lastName"
            name="lastName"
            value={actor.lastName}
            onChange={handleChange}
          />
          </div>
          <div className="mb-3">
          <label htmlFor="lastUpdate" className="form-label">
            Last Update:
          </label>
          <input
            type="date"
            className="form-control"
            id="lastUpdate"
            name="lastUpdate"
            value={actor.lastUpdate}
            onChange={handleChange}
          />
          </div>
        <button type="submit" className="btn btn-success">
          Add Actor
        </button>
      </form>
    </div>
  );
};
 
export default ActorForm;