import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import ActorFilms from "../component/ActorFilms";
import ActorForm from "../component/ActorForm";
import ActorList from "../component/ActorList";
import ActorUpdate from "../component/ActorUpdate";
import ActorTable from "../component/ActorTable";

const ActorManagement = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/actors">
            Actor Management
          </Link>
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
            <ul className="navbar-nav">
              {/* Home Button - links back to the Dashboard */}
              <li className="nav-item">
                <Link className="nav-link" to="/dashboard">
                  Home
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/actors/add">
                  Add Actor
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/actors/list">
                  Search Actors
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/actors/films">
                  Actor Films
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/actors/update">
                  Update Actor
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div className="mt-4">
        <Routes>
          <Route path="/" element={<ActorTable />} />
          <Route path="/add" element={<ActorForm />} />
          <Route path="/list" element={<ActorList />} />
          <Route path="/films" element={<ActorFilms />} />
          <Route path="/update" element={<ActorUpdate />} />
        </Routes>
      </div>
    </div>
  );
};

export default ActorManagement;
