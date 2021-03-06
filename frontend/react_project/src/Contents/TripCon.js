import { useEffect, useState, React, useRef } from 'react';
import axios from 'axios';
import { DataGrid } from '@mui/x-data-grid';
import { ConstructionOutlined } from '@mui/icons-material';
import { MeasureDistances } from '../services/MeasureDistances';
import MapPage from '../pages/MapPage';
import { Navigate } from 'react-router-dom';

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
    field: 'distance',
    headerName: 'Straight-line distance',
    width: '180',
  },
  {
    field: 'avgSpeed',
    headerName: 'Average speed',
    width: '130',
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
  let temp = [];
  let temp1 = [];
  let isMounted = useRef(0);

  useEffect(() => {
    if (isMounted.current < 3) {
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
          getStartCity().map((promise) =>
            Promise.resolve(promise)
              .then((response) =>
                temp.push(response.data.features[0].place_name)
              )
              .then(() => setStartCities(temp))
          );
          getEndCity().map((promise) =>
            Promise.resolve(promise)
              .then((response) =>
                temp1.push(response.data.features[0].place_name)
              )
              .then(() => setEndCities(temp1))
          );
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
              distance: `${getDistance(i)} km`,
              avgSpeed: `${tableData[i].averageSpeed} km/h`,
              topSpeed: `${tableData[i].topSpeed} km/h`,
            };
            // console.log(getDistance(i));
            rows.set(i, trip);
          }
        })
        .finally(() => {
          setTableRows(Array.from(rows.values()));
          isMounted.current++;
        });
    }
    // eslint-disable-next-line
  }, [startCities]);

  const getStartCity = () => {
    let responses = [];
    for (let i = 0; i < lonS.length; i++) {
      var lng = lonS[i];
      var lat = latS[i];
      responses.push(
        axios.get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`
        )
      );
    }
    return responses;
  };
  const getEndCity = () => {
    let responses = [];
    for (let i = 0; i < lonE.length; i++) {
      var lng = lonE[i];
      var lat = latE[i];

      responses.push(
        axios.get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`
        )
      );
    }
    return responses;
  };

  const getDistance = (trip) => {
    // var coordStart = [latS, lonS];
    // var coordEnd = [latE, lonE];

    // for (let i = 0; i < latS.length; i++) {
    var tempLatS = latS[trip];
    var tempLonS = lonS[trip];
    var tempLatE = latE[trip];
    var tempLonE = lonE[trip];

    var start = [tempLatS, tempLonS];
    var end = [tempLatE, tempLonE];

    var coords = {
      start: [tempLatS[0], tempLonS[0]],
      end: [tempLatE[0], tempLonE[0]],
    };
    return MeasureDistances(start, end);
    // }
  };

  return (
    <DataGrid
      rows={tableRows}
      columns={columns}
      checkboxSelection={false}
      sx={{ mt: '4rem' }}
      pageSize={10}
      // disableSelectionOnClick
      disableColumnMenu
      autoHeight
      onSelectionModelChange={(id) => {
        console.log(id);
        <Navigate to="/map" id={id} />;
      }}
    />
  );
};

export default TripCon;
