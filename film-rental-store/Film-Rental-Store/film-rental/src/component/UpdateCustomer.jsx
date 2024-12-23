import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import customerService from "../service/customerService";

const UpdateCustomer = () => {
  const { customerId } = useParams(); // Get customer ID from URL
  const [customer, setCustomer] = useState({
    first_name: "",
    last_name: "",
    email: "",
    active: 1, // Default active state
  }); // Initialize customer state
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  // Fetch customer details on component mount
  useEffect(() => {
    setLoading(true); // Start loading
    customerService
      .fetchCustomerById(customerId)
      .then((data) => {
        setCustomer(data); // Set customer data
        setLoading(false); // Stop loading
      })
      .catch((err) => {
        setError("Failed to load customer details.");
        console.error("Error fetching customer:", err);
        setLoading(false); // Stop loading
      });
  }, [customerId]);

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setCustomer((prev) => ({ ...prev, [name]: value }));
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true); // Start loading

    // Create an object with only the required fields
    const updatedCustomer = {
      first_name: customer.first_name,
      last_name: customer.last_name,
      email: customer.email,
      active: customer.active,
    };

    customerService
      .updateCustomer(customerId, updatedCustomer)
      .then(() => {
        alert("Customer updated successfully!");
        navigate(`/customer-details/${customerId}`); // Redirect to details page
      })
      .catch((err) => {
        setError("Failed to update customer. Please check your inputs.");
        console.error("Error updating customer:", err.response || err);
        setLoading(false); // Stop loading
      });
  };

  if (loading) {
    return <div style={{ textAlign: "center" }}>Loading...</div>;
  }

  if (error) {
    return <div style={{ color: "red", textAlign: "center" }}>{error}</div>;
  }

  return (
    <div className="container mt-5">
      <h1 className="text-center">Update Customer</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>First Name</label>
          <input
            type="text"
            className="form-control"
            name="first_name"
            value={customer.first_name}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Last Name</label>
          <input
            type="text"
            className="form-control"
            name="last_name"
            value={customer.last_name}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            name="email"
            value={customer.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Active</label>
          <select
            className="form-control"
            name="active"
            value={customer.active}
            onChange={handleChange}
          >
            <option value={1}>Active</option>
            <option value={0}>Inactive</option>
          </select>
        </div>
        <div className="text-center mt-4">
          <button
            type="submit"
            className="btn btn-primary"
            disabled={loading} // Disable button during loading
          >
            {loading ? "Updating..." : "Update"}
          </button>
          <button
            type="button"
            className="btn btn-secondary ml-2"
            onClick={() => navigate(-1)}
          >
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default UpdateCustomer;