import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Container, Form, Button, Alert } from 'react-bootstrap';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Replace with your actual login API
      const response = await axios.get(`http://localhost:8080/api/security/login/${username}/${password}`);

      // Assuming the API responds with a token for successful login
      if (response.data) {
        console.log(response.data);
        localStorage.setItem('token', response.data);
        navigate('/dashboard'); // Redirect to the Dashboard page
      } else {
        throw new Error('Invalid credentials'); // Handle unexpected responses
      }
    } catch (err) {
      setError('Invalid username or password');
    }
  };

  const handleRegister = () => {
    navigate('/register'); // Redirect to the registration page
  };

  return (
    <div style={{ backgroundColor: '#f8f9fa', height: '100vh', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <Container className="text-center" style={{ maxWidth: '400px' }}>
        <h1 className="mb-4">Welcome to Film Rental Store</h1>
        <div style={{ backgroundColor: '#343a40', padding: '30px', borderRadius: '10px', boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)' }}>
          <h3 className="text-white mb-4">Staff Login</h3>
          {error && <Alert variant="danger">{error}</Alert>}
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

            <Button variant="danger" type="submit" className="w-100 mb-3">
              Login
            </Button>
          </Form>
          <Button
            variant="outline-light"
            className="w-100"
            onClick={handleRegister}
          >
            Register
          </Button>
        </div>
      </Container>
    </div>
  );
};

export default Login;
