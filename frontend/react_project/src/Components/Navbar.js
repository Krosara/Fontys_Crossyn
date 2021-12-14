import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import { Link as RouterLink } from 'react-router-dom';
import { Link as MaterialLink } from '@mui/material';
import Box from '@mui/material/Box';
const Navbar = () => {
  return (
    <AppBar position="fixed">
      <Toolbar sx={{ display: 'flex', justifyContent: 'space-between' }}>
        <MaterialLink
          component={RouterLink}
          to="/"
          underline="none"
          sx={{
            color: 'white',
            fontSize: '1rem',
          }}
        >
          <Button variant="contained" disableElevation>
            Home
          </Button>
        </MaterialLink>
        <MaterialLink
          component={RouterLink}
          to="/profile"
          underline="none"
          sx={{
            color: 'white',
            fontSize: '1rem',
            alignSelf: 'right',
          }}
        >
          <Button variant="contained" disableElevation>
            Profile
          </Button>
        </MaterialLink>
      </Toolbar>
    </AppBar>
  );
};
export default Navbar;
