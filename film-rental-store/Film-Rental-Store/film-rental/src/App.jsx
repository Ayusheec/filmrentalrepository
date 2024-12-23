import React from 'react'
import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

// Import Login
import Login from './component/Login'
import Register from './component/Register'
import SetCredentials from './component/SetCredentials'
import Dashboard from './component/Dashboard'
import Staff from './component/Staff'
import StoreList from './component/StoreList'
import UpdateEmail from './component/UpdateEmail'

// Import Film
import FilmList from './component/FilmList'
import AddFilm from './component/AddFilm'
import FilmDetails from './component/FilmDetails'
import EditFilm from './component/EditFilm'

 // Import CustomerList
import CustomerList from './component/CustomerList';
import CustomerDetails from './component/CustomerDetails';
import AddCustomer from './component/AddCustomer';
import RentedFilms from './component/RentedFilms';
import UpdateCustomer from './component/UpdateCustomer';

import Payment from './component/Payment';
import ActorManagement from './component/ActorManagement'

function App() {
  return (
    <BrowserRouter>
        <Routes>
        <Route path="/" element={<Login />} />
        <Route path="UpdateEmail/" element={<UpdateEmail/>}/>
        <Route path="/UpdateEmail" element={<UpdateEmail/>}/>
        <Route path="/Login" element={<Login />} />
        <Route path="/Dashboard" element={<Dashboard />} />
        <Route path="/Staff" element={<Staff />} />
        <Route path="/Register" element={<Register />} />
        <Route path="/SetCredentials" element={<SetCredentials />} />
        <Route path="/update-email/:email/:id" element={<UpdateEmail />} />
        <Route path="/StoreList" element={<StoreList/>}/>

        <Route path="/films" element={<FilmList />} />
        <Route path="/add-film" element={<AddFilm />} />
        <Route path="/view-film/:filmId" element={<FilmDetails />} />
        <Route path="/edit-film/:filmId" element={<EditFilm />} />
        <Route path="/film-details/:id" element={<FilmDetails />} />
        
        <Route path="/customers" element={<CustomerList />} />
        <Route path="/customer/details/:customerId" element={<CustomerDetails />} />  
        <Route path="/add-customer" element={<AddCustomer />} />  
        <Route path="/films/customer/:customerId" element={<RentedFilms />} />   
        <Route path="/update-customer/:customerId" element={<UpdateCustomer />} /> 
        <Route path="/customers" element={<CustomerList />} />
        <Route path="/customer-details/:customerId" element={<CustomerDetails />} />
        <Route path="/update-customer/:customerId" element={<UpdateCustomer />} />

        <Route path="/Payments" element={<Payment />} />

        <Route path="/actors/*" element={<ActorManagement />} />

        
      </Routes>
    </BrowserRouter>
  );
}

export default App;