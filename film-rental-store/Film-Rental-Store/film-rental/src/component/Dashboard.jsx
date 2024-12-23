import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import { Link } from 'react-router-dom'; // Import Link for navigation

// Import images correctly
import filmImage from './clapperboard.png';
import staffImage from './service.png';
import paymentImage from './payment-method.png';
import customerImage from './rating.png';
import addressImage from './store.png';
import vloggerImage from './vlogger.png'; // Import the new image for Actor button

const Dashboard = () => {
  // Menu items with imported images and their titles
  const menuItems = [
    { name: 'Film', imgSrc: filmImage, route: '/films' },  // Add the route for the Film page
    { name: 'Staff', imgSrc: staffImage, route: '/staff' },  // Add the route for the Staff page
    { name: 'Customer', imgSrc: customerImage, route: '/customers' },  // Add the route for the Customer page
    { name: 'Payment', imgSrc: paymentImage, route: '/payments' },  // Add the route for the Payment page
    { name: 'Store', imgSrc: addressImage, route: '/StoreList' },  
    { name: 'Actor', imgSrc: vloggerImage, route: '/actors' },  // New Actor button
  ];

  return (
    <div style={{ backgroundColor: '#f8f9fa', padding: '20px' }}>
      {/* Centered Overview Heading */}
      <Container>
        <h1 className="text-center mb-5" style={{ fontSize: '2.5rem', fontWeight: 'bold' }}>
          Overview
        </h1>

        {/* Grid Layout for Images */}
        <Row className="justify-content-center">
          {menuItems.slice(0, 3).map((item, index) => (
            <Col
              key={index}
              xs={6} // 2 columns per row on small screens
              md={4} // 3 columns per row on medium screens
              lg={4} // 3 columns per row on large screens
              className="mb-4 d-flex justify-content-center"
            >
              <div style={{ textAlign: 'center' }}>
                {/* Image Section */}
                <Link to={item.route} style={{ textDecoration: 'none', color: 'inherit' }}>
                  <div style={{ marginBottom: '10px' }}>
                    <img
                      src={item.imgSrc}
                      alt={item.name}
                      className="img-fluid"
                      style={{ maxWidth: '150px', height: 'auto' }}
                    />
                  </div>

                  {/* Title Section */}
                  <h5 style={{ fontSize: '1.25rem', fontWeight: '500', color: '#343a40' }}>
                    {item.name}
                  </h5>
                </Link>
              </div>
            </Col>
          ))}
        </Row>

        {/* Second Row with 2 Icons */}
        <Row className="justify-content-center">
          {menuItems.slice(3).map((item, index) => (
            <Col
              key={index}
              xs={6} // 2 columns per row on small screens
              md={4} // 2 columns per row on medium screens
              lg={4} // 2 columns per row on large screens
              className="mb-4 d-flex justify-content-center"
            >
              <div style={{ textAlign: 'center' }}>
                {/* Image Section */}
                <Link to={item.route} style={{ textDecoration: 'none', color: 'inherit' }}>
                  <div style={{ marginBottom: '10px' }}>
                    <img
                      src={item.imgSrc}
                      alt={item.name}
                      className="img-fluid"
                      style={{ maxWidth: '150px', height: 'auto' }}
                    />
                  </div>

                  {/* Title Section */}
                  <h5 style={{ fontSize: '1.25rem', fontWeight: '500', color: '#343a40' }}>
                    {item.name}
                  </h5>
                </Link>
              </div>
            </Col>
          ))}
        </Row>
      </Container>
    </div>
  );
};

export default Dashboard;
