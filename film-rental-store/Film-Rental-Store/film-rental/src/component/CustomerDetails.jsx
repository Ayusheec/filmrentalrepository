import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import customerService from "../service/customerService";

const CustomerDetails = () => {
  const { customerId } = useParams();
  const [customer, setCustomer] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true); // Loading state
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch customer details by ID
    customerService
      .fetchCustomerById(customerId)
      .then((data) => {
        setCustomer(data);
        setLoading(false); // Stop loading once data is fetched
      })
      .catch((err) => {
        setError("Failed to load customer details.");
        setLoading(false); // Stop loading on error
        console.error(err);
      });
  }, [customerId]);

  // Error message
  if (error) {
    return (
      <div style={{ textAlign: "center", color: "red" }}>
        <p>{error}</p>
        <button className="btn btn-primary" onClick={() => navigate(-1)}>
          Go Back
        </button>
      </div>
    );
  }

  // Loading state
  if (loading) {
    return <div style={{ textAlign: "center" }}>Loading...</div>;
  }

  return (
    <div className="container mt-5">
      <h1 className="text-center">Customer Details</h1>
      <div className="card">
        <div className="card-body">
          <p><strong>First Name:</strong> {customer.first_name}</p>
          <p><strong>Last Name:</strong> {customer.last_name}</p>
          <p><strong>Email:</strong> {customer.email}</p>
          <p><strong>Active:</strong> {customer.active ? "Yes" : "No"}</p>
          <div className="text-center mt-4">
            <button
              className="btn btn-warning"
              onClick={() => navigate(`/update-customer/${customerId}`)}
            >
              Update Customer
            </button>
            <button
              className="btn btn-secondary ml-2"
              onClick={() => navigate("/customers")}
            >
              Go Back
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CustomerDetails;
