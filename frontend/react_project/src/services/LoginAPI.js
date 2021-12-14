import React from 'react';
import axios from 'axios';
import Cookies from 'js-cookie';

axios.defaults.baseURL = 'http://localhost:8080/';

const login = (username, password) => {
  return axios
    .post('login', {
      username: username,
      password: password,
    })
    .then((response) => {
      if (response.data.token) {
        Cookies.set('access_token', JSON.stringify(response.data.access_token));
      }
      return response.data;
    });
};

export { login };
