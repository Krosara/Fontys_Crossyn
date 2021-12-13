import React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import TripCon from '../Contents/TripCon';

const columns = [
  {
    field: 'id',
    headerName: 'ID',
    width: 70,
  },
  {
    field: 'vehicleId',
    headerName: 'Vehicle ID',
    width: 70,
  },
  {
    field: 'startTime',
    headerName: 'Start time',
    width: 70,
  },
  {
    field: 'endTime',
    headerName: 'End time',
    width: 70,
  },
  {
    field: 'startLoc',
    headerName: 'Start location',
    width: 70,
  },
  {
    field: 'endLoc',
    headerName: 'End location',
    width: 70,
  },
];

const TripsPage = () => {
  return (
    <div>
      <TripCon></TripCon>
    </div>
  );
};

export default TripsPage;
