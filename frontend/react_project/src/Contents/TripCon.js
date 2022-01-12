import { useEffect, useState, React } from 'react';
import axios from 'axios';
import { DataGrid } from '@mui/x-data-grid';

const accessToken =
  'sk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3g1M2U2azkyaDJ6MnRsYWZscnh5eDVkIn0.TeE7bH2dRuBGkFcW0ehE8A';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

const columns = [
  {
    field: 'id',
    headerName: 'ID',
    width: '15',
  },
  {
    field: 'vehicleId',
    headerName: 'Vehicle ID',
  },
  {
    field: 'startTime',
    headerName: 'Start time',
    width: '210',
  },
  {
    field: 'endTime',
    headerName: 'End time',
    width: '210',
  },
  {
    field: 'startLoc',
    headerName: 'Start location',
    width: '400',
  },
  {
    field: 'endLoc',
    headerName: 'End location',
    width: '400',
  },
  {
    field: 'avgSpeed',
    headerName: 'Average speed',
  },
  {
    field: 'topSpeed',
    headerName: 'Top speed',
  },
];
const TripCon = (props) => {
  const [tableRows, setTableRows] = useState();
  var lonS = [];
  var latS = [];
  var lonE = [];
  var latE = [];
  const [startCities, setStartCities] = useState([]);
  const [endCities, setEndCities] = useState([]);
  var tableData = [];
  var rows = new Map();

  useEffect(() => {
    axios
      .get(baseURL)
      .then((response) => {
        for (var i = 0; i < response.data.length; i++) {
          tableData.push(response.data[i]);
          let data = response.data[i];
          var dataSize = data.packets.length;
          lonS.push([data.packets[0].location.lon]);
          latS.push([data.packets[0].location.lat]);
          lonE.push([data.packets[dataSize - 1].location.lon]);
          latE.push([data.packets[dataSize - 1].location.lat]);
        }
        // console.log(response.data);
      })
      .then(() => {
        getStartCity();
        getEndCity();
      })
      .then(() => {
        for (let i = 0; i < tableData.length; i++) {
          const trip = {
            id: i + 1,
            vehicleId: tableData[i].vehicleID,
            startTime: tableData[i].startTime,
            endTime: tableData[i].endTime,
            startLoc: startCities[i],
            endLoc: endCities[i],
            avgSpeed: tableData[i].averageSpeed,
            topSpeed: tableData[i].topSpeed,
          };
          rows.set(i, trip);
        }
      })
      .finally(() => setTableRows(Array.from(rows.values())));
    console.log(endCities[0]);
    // console.log(startCities[0]);
    // eslint-disable-next-line
  }, []);

  const getStartCity = async () => {
    var data = [];
    for (let i = 0; i < lonS.length; i++) {
      var lng = lonS[i];
      var lat = latS[i];
      await axios
        .get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`
        )
        .then((response) => {
          data.push(response.data.features[0].place_name);
        });
    }
    setStartCities(data);
  };

  const getEndCity = async () => {
    var data = [];

    for (let i = 0; i < lonE.length; i++) {
      var lng = lonE[i];
      var lat = latE[i];
      await axios
        .get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`
        )
        .then((response) => {
          data.push(response.data.features[0].place_name);
        });
    }
    setEndCities(data);
  };

  //useEffect(() => {

  //})

  return (
    <DataGrid
      rows={tableRows}
      columns={columns}
      checkboxSelection={false}
      sx={{ mt: '4rem' }}
      pageSize={10}
      disableSelectionOnClick
      disableColumnMenu
      autoHeight
    />
  );
};

export default TripCon;
