import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Container, Form, Button, Alert } from 'react-bootstrap';

const Register = () => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Prepare the new staff object
      const newStaff = {
        first_name: firstName,
        last_name: lastName,
        email: email,
        active: 1, // Default active value
      };

      // Send the request to create new staff
      const response = await axios.post(
        'http://localhost:8080/api/staff/post',
        newStaff,
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      );

      setSuccess('Staff successfully registered!');
      setError('');

      // Redirect to SetCredentials page with staffId after successful registration
      setTimeout(() => {
        navigate('/SetCredentials', { state: { staffId: response.data.staff_id } });
      }, 2000);
    } catch (err) {
      console.error('Error during staff registration:', err.response || err);
      setError(err.response?.data?.message || 'Failed to register staff. Please check your input and try again.');
      setSuccess('');
    }
  };

  return (
    <div style={{ backgroundColor: '#f8f9fa', height: '100vh', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <Container className="text-center" style={{ maxWidth: '400px' }}>
        <h1 className="mb-4">Register New Staff</h1>
        <div style={{ backgroundColor: '#343a40', padding: '30px', borderRadius: '10px', boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)' }}>
          {error && <Alert variant="danger">{error}</Alert>}
          {success && <Alert variant="success">{success}</Alert>}
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3">
              <Form.Label className="text-white">First Name</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter first name"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                required
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label className="text-white">Last Name</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter last name"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                required
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label className="text-white">Email</Form.Label>
              <Form.Control
                type="email"
                placeholder="Enter email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </Form.Group>

            <Button variant="primary" type="submit" className="w-100">
              Create Account
            </Button>
          </Form>
        </div>
      </Container>
    </div>
  );
};

export default Register;
