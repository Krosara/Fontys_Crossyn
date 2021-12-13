import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';

const Navbar = () => {
  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Button
            variant="contained"
            disableElevation
            sx={{
              color: 'white',
              display: 'block',
              fontSize: '1rem',
            }}
          >
            Home
          </Button>
          <Button
            variant="contained"
            disableElevation
            sx={{
              color: 'white',
              display: 'block',
              fontSize: '1rem',
            }}
          >
            Profile
          </Button>
        </Toolbar>
      </Container>
    </AppBar>
  );
};
export default Navbar;
