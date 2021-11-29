import React, {useState} from "react";
import axios from 'axios';
import AccountImage from './img/account.png';


function Account() {
  
  const [usernameReg, setUsernameReg] = useState("");
  const [passwordReg, setPasswordReg] = useState("");

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const register =() =>{
    axios.post('http://localhost:3306/account', {
      username: usernameReg,
      password: passwordReg,}).then((response) =>{
        console.log(response);
      });
  };

  const login =() =>{
    axios.post('http://localhost:3306/account', {
      username: username,
      password: password,}).then((response) =>{
        console.log(response);
      });
  };


  return (
    <div className="App">
      <header className="mars-header">
        <img src={AccountImage}  className="App-logo" alt="logo" />
      </header>
      <h1>Account Management</h1>  

      <div className="registration">
      <h2>
        Register
      </h2>
      <input type="text" onChange={(e) => {setUsernameReg(e.target.value)}} placeholder="Username..." id="Username"></input>
      <br></br>
      <br></br>
      <input type="password" onChange={(e) => {setPasswordReg(e.target.value)}} placeholder="Password..." id="Password"></input>
      <br></br>
      <br></br>
      <button onClick={register}>Sign Up</button>
      </div>

      <div className="login">
      <h2>
        Login
      </h2>
      <input type="text" onChange={(e) => {setUsername(e.target.value)}} placeholder="Username..." id="Username"></input>
      <br></br>
      <br></br>
      <input type="password" onChange={(e) => {setPassword(e.target.value)}} placeholder="Password..." id="Password"></input>
      <br></br>
      <br></br>
      <button onClick={login}>Sign In</button>
        </div>
        <br></br>

    </div>     
  );
}

export default Account;

