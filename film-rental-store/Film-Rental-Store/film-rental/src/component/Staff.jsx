import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import staffService from "../service/StaffService";

const StaffList = () => {
    const [staffList, setStaffList] = useState([]);
    const [error, setError] = useState(null);
    const [searchQuery, setSearchQuery] = useState(""); // Add state for search query
    const navigate = useNavigate();

    useEffect(() => {
        // Fetch all staff initially when the component loads
        staffService
            .fetchAll()
            .then((data) => {
                if (Array.isArray(data)) {
                    setStaffList(data);
                } else {
                    setError("Invalid response structure from the server.");
                }
            })
            .catch((err) => {
                setError(`Error fetching staff: ${err.message}`);
            });
    }, []);

    const handleSearch = (e) => {
        e.preventDefault();
        staffService
            .searchByFirstName(searchQuery)
            .then((data) => {
                setStaffList(data);
            })
            .catch((err) => {
                setError(`Error searching staff: ${err.message}`);
            });
    };

    if (error) {
        return <div className="text-danger">{error}</div>;
    }

    if (staffList.length === 0) {
        return <div className="text-center mt-4">Loading staff...</div>;
    }

    return (
        <div className="container-fluid staff-container py-4">
            {/* Navbar */}
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark shadow-lg mb-4">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">Staff Management</a>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarNav"
                        aria-controls="navbarNav"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav ms-auto">
                            <li className="nav-item">
                                <Link to="/Dashboard" className="nav-link">Home</Link>
                            </li>
                            {/* Search Form */}
                            <li className="nav-item">
                                <form className="d-flex" onSubmit={handleSearch}>
                                    <input
                                        className="form-control me-2"
                                        type="search"
                                        placeholder="Search staff by firstname"
                                        aria-label="Search"
                                        value={searchQuery}
                                        onChange={(e) => setSearchQuery(e.target.value)} // Handle input change
                                    />
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            {/* Staff Table */}
            <h1 className="text-center" style={{ color: 'black' }}>Staff List</h1>
            <div className="table-responsive mt-4">
                <table className="table table-bordered table-hover table-sm align-middle">
                    <thead className="table-dark text-center">
                        <tr>
                            <th>Staff ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Active</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
  {staffList.map((staff) => (
    <tr key={staff.staff_id}>
      <td className="text-center">{staff.staff_id}</td>
      <td className="text-truncate">{staff.first_name}</td>
      <td className="text-truncate">{staff.last_name}</td>
      <td className="text-truncate">{staff.email}</td>
      <td className="text-center">{staff.active ? "Yes" : "No"}</td>
      <td className="text-center">
        {/* Update Email Button */}
        <Link
          to={`/update-email/${staff.email}/${staff.staff_id}`}
          className="btn btn-primary btn-sm me-2"
        >
          <i className="bi bi-pencil-square"></i> Update Email
        </Link>
      </td>
    </tr>
  ))}
</tbody>

                </table>
            </div>
        </div>
    );
};

export default StaffList;
