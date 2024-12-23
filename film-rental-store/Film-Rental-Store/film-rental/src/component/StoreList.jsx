import React, { useState } from "react";
import axios from "axios";
import { Container, Row, Col, Form, Button, Table, Alert, Navbar, Nav } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import { Link } from "react-router-dom";
 
const StoreStaffPage = () => {
  const [storeId, setStoreId] = useState("");
  const [staffList, setStaffList] = useState([]);
  const [error, setError] = useState("");
 
  const handleSearch = async (e) => {
    e.preventDefault();
    console.log(storeId);  // Log the storeId to verify
    setError(""); // Clear previous error
    try {
        const response = await axios.get(`http://localhost:8080/api/store/staff/${storeId}`);
        console.log(response.data);  // Log the response to inspect the structure
        setStaffList(response.data);
    } catch (err) {
        setError("Unable to fetch staff. Please check the Store ID and try again.");
        setStaffList([]);
    }
  };
  
 
 
  return (
    <div className="d-flex justify-content-center align-items-center min-vh-100 text-light">
      <Container className="p-4 rounded bg-secondary shadow-lg">
        {/* Navbar */}
        <Navbar bg="dark" variant="dark" className="mb-4" >
          <Navbar.Brand as={Link} to="/" className="d-flex align-items-center">
            <i className="bi bi-house-door-fill me-2"></i> Home
          </Navbar.Brand>
        </Navbar>
 
        {/* Header */}
        <Row className="text-center mb-4">
          <Col>
            <h1>
              <i className="bi bi-people-fill text-warning"></i> Store Staff Search
            </h1>
            <p>Search and view staff assigned to a specific store.</p>
          </Col>
        </Row>
 
        {/* Search Bar */}
        <Row className="justify-content-center">
          <Col md={8}>
            <Form onSubmit={handleSearch} className="d-flex">
              <Form.Control
                type="number"
                placeholder="Enter Store ID"
                value={storeId}
                onChange={(e) => setStoreId(e.target.value)}
                required
                className="me-2"
              />
              <Button variant="warning" type="submit">
                <i className="bi bi-search"></i> Search
              </Button>
            </Form>
          </Col>
        </Row>
 
        {/* Error Message */}
        {error && (
          <Row className="justify-content-center mt-3">
            <Col md={8}>
              <Alert variant="danger" className="d-flex align-items-center">
                <i className="bi bi-exclamation-circle me-2"></i> {error}
              </Alert>
            </Col>
          </Row>
        )}
 
        {/* Staff Table */}
        {staffList.length > 0 && (
          <Row className="mt-4">
            <Col>
              <Table striped bordered hover responsive className="bg-light text-center">
                <thead className="table-dark">
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                  </tr>
                </thead>
                <tbody>
                  {staffList.map((staff, index) => (
                    <tr key={staff.staff_id}>
                      <td>{index + 1}</td>
                      <td>{staff.first_name}</td>
                      <td>{staff.last_name}</td>
                      <td>{staff.email || "N/A"}</td>
                      <td>{staff.phone || "N/A"}</td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            </Col>
          </Row>
        )}
      </Container>
    </div>
  );
};
 
export default StoreStaffPage;