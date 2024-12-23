import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const AddCustomer = () => {
  const [customer, setCustomer] = useState({
    first_name: "",
    last_name: "",
    email: "",
    address_id: "",
    store_id: "",
    active: 1, // Default active to Yes (1)
    create_date: "", // Format: yyyy-MM-ddTHH:mm (datetime-local)
  });

  const [error, setError] = useState(null);
  const navigate = useNavigate();

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setCustomer((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
  
    // Add seconds to the datetime value if they are missing
    const formattedDate = customer.create_date.includes(":")
      ? `${customer.create_date}:00`
      : customer.create_date;
  
    const updatedCustomer = {
      first_name: customer.first_name.trim(),
      last_name: customer.last_name.trim(),
      email: customer.email.trim(),
      address_id: Number(customer.address_id),
      store_id: Number(customer.store_id),
      active: customer.active,
      create_date: formattedDate,
    };
  
    console.log("Payload being sent to backend:", updatedCustomer);
  
    try {
      const response = await axios.post("http://localhost:8080/api/customers/post", updatedCustomer);
      alert("Customer added successfully!");
      setCustomer({
        first_name: "",
        last_name: "",
        email: "",
        address_id: "",
        store_id: "",
        active: 1,
        create_date: "",
      });
      navigate("/customers");
    } catch (error) {
      console.error("Error adding customer:", error.response?.data || error.message);
      setError(error.response?.data?.message || "Failed to add customer.");
    }
  };
  
  return (
    <div className="container mt-5">
      <h1>Add New Customer</h1>

      {/* Display error message if any */}
      {error && <p style={{ color: "red" }}>{error}</p>}

      <form onSubmit={handleSubmit}>
        {/* First Name */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="firstName" className="form-label">
              First Name
            </label>
          </div>
          <div className="col-md-8">
            <input
              type="text"
              id="firstName"
              name="first_name"
              className="form-control"
              value={customer.first_name}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        {/* Last Name */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="lastName" className="form-label">
              Last Name
            </label>
          </div>
          <div className="col-md-8">
            <input
              type="text"
              id="lastName"
              name="last_name"
              className="form-control"
              value={customer.last_name}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        {/* Email */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="email" className="form-label">
              Email
            </label>
          </div>
          <div className="col-md-8">
            <input
              type="email"
              id="email"
              name="email"
              className="form-control"
              value={customer.email}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        {/* Address */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="address_id" className="form-label">
              Address ID
            </label>
          </div>
          <div className="col-md-8">
            <input
              type="number"
              id="address_id"
              name="address_id"
              className="form-control"
              value={customer.address_id}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        {/* Store */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="store_id" className="form-label">
              Store ID
            </label>
          </div>
          <div className="col-md-8">
            <input
              type="number"
              id="store_id"
              name="store_id"
              className="form-control"
              value={customer.store_id}
              onChange={handleChange}
              min="1"
              required
            />
          </div>
        </div>

        {/* Active Status */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="active" className="form-label">
              Active
            </label>
          </div>
          <div className="col-md-8">
            <select
              id="active"
              name="active"
              className="form-control"
              value={customer.active}
              onChange={handleChange}
              required
            >
              <option value={1}>Yes</option>
              <option value={0}>No</option>
            </select>
          </div>
        </div>

        {/* Create Date */}
        <div className="row mb-3">
          <div className="col-md-4">
            <label htmlFor="create_date" className="form-label">
              Create Date
            </label>
          </div>
          <div className="col-md-8">
            <input
              type="datetime-local"
              id="create_date"
              name="create_date"
              className="form-control"
              value={customer.create_date}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
};

export default AddCustomer;
