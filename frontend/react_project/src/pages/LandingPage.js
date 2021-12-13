import React from 'react';
import {
  Card,
  CardContent,
  Typography,
  CardMedia,
  CardActionArea,
  Grid,
} from '@mui/material';
import Trip from '../assets/map.svg';
import Vehicle from '../assets/car.svg';
import Profile from '../assets/account.svg';
import { Link as RouterLink } from 'react-router-dom';
import { Link as MaterialLink } from '@mui/material';

const LandingPage = () => {
  return (
    <Grid
      container
      direction="row"
      align="center"
      spacing={2}
      sx={{ justifyContent: 'center', mx: 'auto' }}
    >
      <Grid item display="flex" justify="center" direction="row">
        <Card sx={{ maxWidth: 345 }}>
          <MaterialLink component={RouterLink} to="/trips" underline="none">
            <CardActionArea>
              <CardMedia
                component="img"
                height="140"
                image={Trip}
                alt="Trips"
                sx={{
                  width: '40%',
                  margin: 'auto',
                  height: '40%',
                  marginTop: '1rem',
                }}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Trips
                </Typography>
              </CardContent>
            </CardActionArea>
          </MaterialLink>
        </Card>
      </Grid>
      <Grid item display="flex" justify="center" direction="row">
        <Card sx={{ maxWidth: 345 }}>
          <MaterialLink component={RouterLink} to="/vehicles" underline="none">
            <CardActionArea>
              <CardMedia
                component="img"
                height="140"
                image={Vehicle}
                alt="Vehicles"
                sx={{
                  width: '40%',
                  margin: 'auto',
                  height: '40%',
                  marginTop: '1rem',
                }}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Vehicles
                </Typography>
              </CardContent>
            </CardActionArea>
          </MaterialLink>
        </Card>
      </Grid>
      <Grid item display="flex" justify="center" direction="row">
        <Card sx={{ maxWidth: 345 }}>
          <MaterialLink component={RouterLink} to="/account" underline="none">
            <CardActionArea>
              <CardMedia
                component="img"
                height="140"
                image={Profile}
                alt="Profile"
                sx={{
                  width: '40%',
                  margin: 'auto',
                  height: '35%',
                  marginTop: '1rem',
                }}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Account
                </Typography>
              </CardContent>
            </CardActionArea>
          </MaterialLink>
        </Card>
      </Grid>
    </Grid>
  );
};

export default LandingPage;
