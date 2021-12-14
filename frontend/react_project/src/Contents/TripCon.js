import { useEffect, useState, React } from 'react';
import axios from 'axios';
import mapboxgl from 'mapbox-gl';
import { DataGrid } from '@mui/x-data-grid';

const accessToken =
  'sk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3g1M2U2azkyaDJ6MnRsYWZscnh5eDVkIn0.TeE7bH2dRuBGkFcW0ehE8A';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

const columns = [
  {
    field: 'id',
    headerName: 'ID',
  },
  {
    field: 'vehicleId',
    headerName: 'Vehicle ID',
  },
  {
    field: 'startTime',
    headerName: 'Start time',
  },
  {
    field: 'endTime',
    headerName: 'End time',
  },
  {
    field: 'startLoc',
    headerName: 'Start location',
  },
  {
    field: 'endLoc',
    headerName: 'End location',
    width: '100',
  },
];

const TripCon = (props) => {
  const [tripID, setTripID] = useState([]);
  const [tableRows, setTableRows] = useState([]);
  var lonS = [];
  var latS = [];
  var lonE = [];
  var latE = [];
  var data = [];
  var startCities = [];
  var endCities = [];
  /* var dataId = [];
     var vehicleId = [];
     var startTime = [];
     var endTime = [];*/
  var tableData = [];
  var rows = new Map();
  var rows1 = [];

  useEffect(() => {
    axios
      .get(baseURL)
      .then((response) => {
        for (var i = 0; i < response.data.length; i++) {
          tableData.push(response.data[i]);
          let data = response.data[i];
          /*dataId.push(data._id);
                vehicleId.push(data.vehicleID);
                startTime.push(data.startTime);
                endTime.push(data.endTime);*/
          var dataSize = data.packets.length;
          lonS.push([data.packets[0].location.lon]);
          latS.push([data.packets[0].location.lat]);
          lonE.push([data.packets[dataSize - 1].location.lon]);
          latE.push([data.packets[dataSize - 1].location.lat]);
        }
        // console.log(tableData);
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
          };
          rows.set(i, trip);

          //   console.log(rows);
          //   console.log(Array.from(rows.values()));
        }
      })
      .finally(() => setTableRows(Array.from(rows.values())));

    rows1.push(tableRows);
    // console.log(tableRows);
    getStartCity();
    getEndCity();

    // eslint-disable-next-line
  }, []);

  const getStartCity = () => {
    for (let i = 0; i < lonS.length; i++) {
      var lng = lonS[i];
      var lat = latS[i];
      axios
        .get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`
        )
        .then((response) => {
          startCities.push(response.data.features[0].place_name);
        });
    }
    // console.log(startCities);
  };

  const getEndCity = () => {
    for (let i = 0; i < lonE.length; i++) {
      var lng = lonE[i];
      var lat = latE[i];
      axios
        .get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`
        )
        .then((response) => {
          endCities.push(response.data.features[0].place_name);
        });
    }
    // console.log(endCities);
  };

  //useEffect(() => {

  //})

  return (
    <DataGrid
      rows={tableRows}
      {...console.log(tableRows)}
      columns={columns}
      pageSize={10}
      rowsPerPageOptions={[10]}
      checkboxSelection={false}
      sx={{ mt: '4rem' }}
    />
    //<div></div>
  );
};

export default TripCon;
