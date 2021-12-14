import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
const Navbar = () => {
  return (
    <AppBar position="fixed">
      <Toolbar>
        <Button
          variant="contained"
          disableElevation
          sx={{
            color: 'white',
            fontSize: '1rem',
            flex: '1',
          }}
        >
          Home
        </Button>
        <Button
          variant="contained"
          disableElevation
          sx={{
            color: 'white',
            fontSize: '1rem',
            flex: '1',
          }}
        >
          Profile
        </Button>
      </Toolbar>
    </AppBar>
  );
};
export default Navbar;
