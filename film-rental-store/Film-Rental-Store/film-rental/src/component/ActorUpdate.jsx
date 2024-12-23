import React, { useState } from "react";
import actorService from "../service/actorService";
 
const ActorUpdate = () => {
  const [actorId, setActorId] = useState("");
  const [updateType, setUpdateType] = useState("firstName");
  const [newName, setNewName] = useState("");
 
  const handleUpdate = async () => {
    try {
      if (updateType === "firstName") {
        await actorService.updateFirstName(actorId, newName);
        alert("First name updated successfully!");
      } else {
        await actorService.updateLastName(actorId, newName);
        alert("Last name updated successfully!");
      }
    } catch (error) {
      console.error("Error updating actor:", error);
      alert("Failed to update actor. Please check the details and try again.");
    }
  };
 
  return (
    <div className="container mt-5">
      <h2 className="mb-4">Update Actor Name</h2>
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
      <div className="mb-3">
        <label htmlFor="updateType" className="form-label">
          Update:
        </label>
        <select
          className="form-select"
          id="updateType"
          value={updateType}
          onChange={(e) => setUpdateType(e.target.value)}
        >
          <option value="firstName">First Name</option>
          <option value="lastName">Last Name</option>
        </select>
      </div>
      <div className="mb-3">
        <label htmlFor="newName" className="form-label">
          New Name:
        </label>
        <input
          type="text"
          className="form-control"
          id="newName"
          value={newName}
          onChange={(e) => setNewName(e.target.value)}
        />
      </div>
      <button className="btn btn-primary" onClick={handleUpdate}>
        Update Name
      </button>
    </div>
  );
};
 
export default ActorUpdate;