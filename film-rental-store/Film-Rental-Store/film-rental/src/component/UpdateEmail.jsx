import React, { useState, useEffect } from 'react';
import { useNavigate, useParams, Link } from 'react-router-dom';
import axios from 'axios';
import { Container, Navbar, Nav, Form, Button, Alert, Modal } from 'react-bootstrap';

const UpdateEmail = () => {
  const { email: initialEmail, id: staffIdParam } = useParams(); // Get initial email and staffId from URL params
  const [email, setEmail] = useState(initialEmail);  // Initialize with the email from params
  const [staffId, setStaffId] = useState(staffIdParam); // Initialize with the staff ID from params
  const [error, setError] = useState('');
  const [showSuccessModal, setShowSuccessModal] = useState(false); // For success popup
  const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!email || !staffId) {
      setError('Staff ID and Email are required!');
      return;
    }

    try {
      const response = await axios.put(`http://localhost:8080/api/staff/updatep/${email}/${staffId}`);
      if (response.status === 200) {
        setError('');
        setShowSuccessModal(true); // Show success modal
      } else {
        setError('Failed to update email. Please try again.');
      }
    } catch (err) {
      setError('Failed to update email. Please try again.');
    }
  };

  const handleModalClose = () => {
    setShowSuccessModal(false); // Close modal
    navigate('/Staff'); // Redirect to staff list after success
  };

  useEffect(() => {
    // If the params are updated (i.e., the URL changes), update state values
    setEmail(initialEmail);
    setStaffId(staffIdParam);
  }, [initialEmail, staffIdParam]);

  return (
    <>
      {/* Navbar */}
      <Navbar bg="dark" variant="dark" expand="lg">
        <Container>
          <Navbar.Brand>Staff Management</Navbar.Brand>
          <Nav className="ml-auto">
            <Nav.Link as={Link} to="/Staff">Home</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      {/* Form Section */}
      <Container className="py-4">
        <h1 style={{ color: 'black', textAlign: 'center' }} className="mb-4">
          Update Staff Email
        </h1>
        {error && <Alert variant="danger">{error}</Alert>}
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3">
            <Form.Label>Staff ID</Form.Label>
            <Form.Control
              type="number"
              placeholder="Enter Staff ID"
              value={staffId}
              onChange={(e) => setStaffId(e.target.value)}
              required
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>New Email</Form.Label>
            <Form.Control
              type="email"
              placeholder="Enter new email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </Form.Group>

          <Button variant="primary" type="submit">
            Update Email
          </Button>
        </Form>
      </Container>

      {/* Success Modal */}
      <Modal show={showSuccessModal} onHide={handleModalClose} centered>
        <Modal.Header closeButton>
          <Modal.Title>Email Updated</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p>Email updated successfully!</p>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="primary" onClick={handleModalClose}>
            Go to Staff List
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default UpdateEmail;
