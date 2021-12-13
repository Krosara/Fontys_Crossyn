import React from 'react';
import { DataGrid } from '@mui/x-data-grid';

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
<<<<<<< HEAD
=======
];const columns = [
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
>>>>>>> origin/development-Kaloyan
];

const TripsPage = () => {
  return (
    <div>
      {/* <DataGrid
        rows=
        columns=
        pageSize={10}
        rowsPerPageOptions={[10]}
        checkboxSelection
      /> */}
    </div>
  );
};

export default TripsPage;
