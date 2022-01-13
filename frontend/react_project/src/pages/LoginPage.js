import { useState } from 'react';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import { login } from '../services/LoginAPI';
import Button from '@mui/material/Button';

const LoginPage = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    login(username, password);
  };
  return (
    <Grid
      container
      direction="column"
      sx={{
        margin: '0',
        position: 'absolute',
        top: '50%',
        transform: 'translateY(-50%)',
      }}
      justify="center"
      justifyContent="center"
      alignItems="center"
    >
      <Grid item>
        <Box
          component="form"
          onSubmit={handleSubmit}
          sx={{
            '& .MuiTextField-root': { m: 1, width: '25ch' },
            // position: 'absolute',
            top: '50%',
            transform: 'translateY(-50%)',
            justifyContent: 'center',
            textAlign: 'center',
            align: 'center',
          }}
          noValidate
          autoComplete="off"
        >
          <div>
            <TextField
              required
              id="outlined-error"
              label="Username"
              onChange={(e) => setUsername(e.target.value)}
            />
            <TextField
              required
              id="outlined-error-helper-text"
              label="Password"
              type="password"
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <Button variant="contained" type="submit">
            Login
          </Button>
        </Box>
      </Grid>
    </Grid>
  );
};

export default LoginPage;
