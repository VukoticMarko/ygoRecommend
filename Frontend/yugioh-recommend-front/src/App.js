import React, { Component } from "react";
import Button from 'react-bootstrap/Button';
import Recommend from "./recommend/recommend";
import { Link, Outlet } from "react-router-dom";
import "./App.css";

function App() {
  return (
    <div className="App">
       <h1>Yugioh Deck Recommender</h1>
      <nav
        style={{
          borderBottom: "solid 1px",
          paddingBottom: "1rem",
        }}
      >   
           <Link to="/recommend">
            <Button>Start</Button>
          </Link>    
      </nav>
      <Outlet />
    </div>
  );
}

export default App;