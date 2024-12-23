import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import { Container, Form, Button, Modal } from 'react-bootstrap';

const SetCredentials = () => {
  const location = useLocation();
  const { staffId } = location.state || {}; // Get staffId from the location state
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [showModal, setShowModal] = useState(false);
  const navigate = useNavigate();

  // Redirect to home page if no staffId is found
  if (!staffId) {
    navigate('/'); // Redirect to the login page
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!staffId) {
      navigate('/'); // Redirect to login page if staffId is not found
      return; // Exit the function
    }

    try {
      const newSecurity = {
        username,
        password,
        staff_id: staffId, // Link the username/password to the staff
      };

      // Send the request to create the security details
      const response = await axios.post('http://localhost:8080/api/security/add', newSecurity);
      setShowModal(true);

      setTimeout(() => navigate('/'), 2000); // Redirect to login page after success
    } catch (err) {
      console.error('Error creating security:', err);
    }
  };

  return (
    <div style={{ backgroundColor: '#f8f9fa', height: '100vh', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <Container className="text-center" style={{ maxWidth: '400px' }}>
        <h1 className="mb-4">Set Username and Password</h1>
        <div style={{ backgroundColor: '#343a40', padding: '30px', borderRadius: '10px', boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)' }}>
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3">
              <Form.Label className="text-white">Username</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label className="text-white">Password</Form.Label>
              <Form.Control
                type="password"
                placeholder="Enter password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </Form.Group>

            <Button variant="primary" type="submit" className="w-100">
              Submit
            </Button>
          </Form>
        </div>
      </Container>

      {/* Success Modal */}
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>Account Created!</Modal.Title>
        </Modal.Header>
        <Modal.Body>Your account has been successfully created.</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>Close</Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default SetCredentials;
