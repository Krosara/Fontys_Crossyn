import { useState } from 'react';
import Box from '@mui/material/Box';
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
    <div>
      <Box
        component="form"
        onSubmit={handleSubmit}
        sx={{
          '& .MuiTextField-root': { m: 1, width: '25ch' },
          position: 'absolute',
          top: '50%',
          transform: 'translateY(-50%)',
          justifyContent: 'center',
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
    </div>
  );
};

export default LoginPage;
