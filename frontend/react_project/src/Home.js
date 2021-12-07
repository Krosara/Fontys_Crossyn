import './App.css';
import Trips from './img/trips.png';
import Vehicle from './img/vehicle.png';
import React from "react";
import Account from './img/account.png';


function Home() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={Trips}  className="App-logo" alt="logo" />
        <a
          className="App-link"
          href="/trips"
          rel="noopener noreferrer"
        >
        Your Trips 
        </a>
      </header>
      <br></br>
      <header className="App-header">
        <img src={Vehicle} className="App-logo" alt="logo" />
        <a
          className="App-link"
          href="/vehicle"
          rel="noopener noreferrer"
        >      
        Vehicles
        </a>
      </header>
      <br></br>
      <header className="App-header">
        <img src={Account} className="App-logo" alt="logo" />
        <a
          className="App-link"
          href="/account"
          rel="noopener noreferrer"
        >
        Account Management
        </a>
        <br></br>
        <br></br>

      </header>
    </div> 
  );
}
   
export default Home;
