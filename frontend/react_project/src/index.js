import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
// var express = require('express')
// const mysql = require("mysql");
// const cors = require("cors");

// var app = express()

// app.use(express.json());
// app.use(cors());

// const db = mysql.createConnection({
//   user: "root",
//   host: "localhost",
//   password: "",
//   database: "StellaNova"
// });

// app.post('/register', (req, res)=>{

//   const username = req.body.username;
//   const password = req.body.password;

//     db.query("INSERT INTO users (accountName, accountPassword) VALUES (?,?)", 
//     [username, password],
//     (err, result)=>
//     {
//       console.log(err);
//     }
//   );
// });

// app.post('/login', (req, res)=>{

//   const username = req.body.username;
//   const password = req.body.password;

//     db.query("SELECT * users WHERE username = ? AND password = ?", 
//     [username, password], 
//     (err, result)=>
//     {
//       if(err)
//       {
//         res.send({err: err});
//       } 
//         if(result.lenght > 0)
//         {
//           res.send(result);
//         } else{
//           res.send({message: "Could not log in"});
//         }
//     }
//   );
// });

// app.listen(3006, () =>{
//   console.log("Server is running on port 3006");
// });

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
