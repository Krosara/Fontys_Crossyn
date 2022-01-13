import React from 'react';
import axios from 'axios';
// import Cookies from 'js-cookie';

axios.defaults.baseURL = 'http://localhost:8080/';

const login = (username, password) => {
  // const xhr = new XMLHttpRequest();
  // xhr.open('POST', 'http://localhost:8080/login');
  // xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
  // xhr.setRequestHeader('Content-Type', 'application/xml');
  // xhr.send(
  //   `<user><username>${username}</username><password>${password}</password></user>`
  // );
  return axios
    .post(
      'login',
      {
        username: username,
        password: password,
      },
      {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      }
    )
    .then((response) => {
      if (response.data.token) {
        // Cookies.set('access_token', JSON.stringify(response.data.access_token));
      }
      // console.log(response.data.headers['Access-Control-Allow-Origin']);
      return response.data;
    });
};

export { login };
