import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import customerService from "../service/customerService";

const CustomerList = () => {
  const [customers, setCustomers] = useState([]);
  const [error, setError] = useState(null);
  const [searchName, setSearchName] = useState("");
  const [isLoading, setIsLoading] = useState(true); // Track loading state
  const navigate = useNavigate();

  // Fetch all customers initially when the component is mounted
  useEffect(() => {
    customerService
      .fetchAllCustomers()
      .then((data) => {
        if (Array.isArray(data)) {
          setCustomers(data);
        } else {
          setError("Invalid response structure from the server.");
        }
      })
      .catch((err) => {
        setError(`Error fetching customers: ${err.message}`);
      })
      .finally(() => setIsLoading(false)); // Set loading to false when done
  }, []);

  // Search customers by name
  const handleSearchByName = () => {
    if (!searchName.trim()) {
      alert("Please enter a name to search.");
      setCustomers([]); // Clear customers if the search is empty
      return;
    }
    setIsLoading(true); // Start loading when search is triggered
    customerService
      .fetchByFirstName(searchName) // Use fetchByFirstName instead of fetchByName
      .then((data) => {
        if (Array.isArray(data) && data.length > 0) {
          setCustomers(data);
          setError(null);
        } else {
          setCustomers([]);
          setError("No customers found with the specified name.");
        }
      })
      .catch((err) => {
        setError(`Error fetching customers by name: ${err.message}`);
        setCustomers([]); // Clear customers if there is an error
      })
      .finally(() => setIsLoading(false)); // Set loading to false when done
  };

  // Handle customer deletion
  const handleDeleteCustomer = (customerId) => {
    if (window.confirm("Are you sure you want to delete this customer?")) {
      customerService
        .deleteCustomer(customerId) // Assume deleteCustomer method exists in the service
        .then(() => {
          setCustomers(customers.filter((customer) => customer.customer_id !== customerId)); // Remove deleted customer from state
        })
        .catch((err) => {
          setError(`Error deleting customer: ${err.message}`);
        });
    }
  };

  // Navigate to the add customer page
  const handleAddCustomer = () => {
    navigate("/add-customer");
  };

  return (
    <div className="container">
      {/* Navbar */}
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark shadow-lg mb-4">
        <div className="container-fluid">
          <a className="navbar-brand" href="/">
            Customer Management
          </a>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
                <div className="d-flex">
                  <input
                    type="text"
                    className="form-control me-2"
                    placeholder="Search by name"
                    value={searchName}
                    onChange={(e) => setSearchName(e.target.value)}
                  />
                  <button
                    className="btn btn-outline-success"
                    onClick={handleSearchByName}
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
                  onClick={handleAddCustomer}
                  title="Add Customer"
                >
                  <i className="bi bi-plus" style={{ fontSize: "1.5rem" }}></i>
                </span>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      {/* Customer List */}
      <h1 className="mt-4 mb-4 text-center">Customer List</h1>
      {error && <div className="alert alert-danger">{error}</div>}

      {/* Loading or No Customers Found */}
      {isLoading ? (
        <div className="text-center">Loading customers...</div>
      ) : customers.length === 0 ? (
        <div className="text-center">No customers to display.</div>
      ) : (
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Actions</th>
              <th>Remove</th> {/* New Column */}
            </tr>
          </thead>
          <tbody>
            {customers.map((customer) => (
              <tr key={customer.customer_id}>
                <td>{customer.first_name}</td>
                <td>{customer.last_name}</td>
                <td>{customer.email}</td>
                <td>
                  <button
                    className="btn btn-info btn-sm"
                    onClick={() => navigate(`/customer-details/${customer.customer_id}`)}
                  >
                    View Details
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => handleDeleteCustomer(customer.customer_id)}
                    title="Remove Customer"
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

export default CustomerList;
