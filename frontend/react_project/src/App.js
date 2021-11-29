import './App.css';
import React from "react";
import Home from './Home';
import Trips from './Trips';
import Vehicle from './Vehicle';
import Account from './Account';

function App() {
  
  if (window.location.href.indexOf("home") > -1) {
  return (
    <Home></Home>
  );
  }
  if (window.location.href.indexOf("trips") > -1) {
    return (
      <Trips></Trips>
    );
    }
    if (window.location.href.indexOf("vehicle") > -1) {
      return (
        <Vehicle></Vehicle>
      );
      }    
      if (window.location.href.indexOf("account") > -1) {
        return (
          <Account></Account>
        );
        }          
    else{
      return (
        <Home></Home>
        );
    }
}
   
export default App;
