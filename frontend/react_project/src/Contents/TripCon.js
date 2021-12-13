import { useEffect, useState, React } from 'react';
import axios from 'axios';
import mapboxgl from 'mapbox-gl';
import { DataGrid } from '@mui/x-data-grid';


const accessToken = 'sk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3g1M2U2azkyaDJ6MnRsYWZscnh5eDVkIn0.TeE7bH2dRuBGkFcW0ehE8A';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

const TripCon = (props) => {

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



    const [tripID, setTripID] = useState([]);
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
    var rows = [];
    

    useEffect(async () => {
        await axios.get(baseURL).then((response) => {
            for (var i = 0; i < response.data.length; i++) {
                tableData.push(response.data[i]);
                data = response.data[i];
                /*dataId.push(data._id);
                vehicleId.push(data.vehicleID);
                startTime.push(data.startTime);
                endTime.push(data.endTime);*/
                var dataSize = data.packets.length;
                lonS.push([data.packets[0].location.lon])
                latS.push([data.packets[0].location.lat])
                lonE.push([data.packets[dataSize - 1].location.lon])
                latE.push([data.packets[dataSize - 1].location.lat])
            }

            for (let i = 0; i < tableData.length; i++) {
                var trip = {};
                trip["id"] = tableData[i]._id;
                trip["vehicleId"] = tableData[i].vehicleID;
                trip["startTime"] = tableData[i].startTime;
                trip["endTime"] = tableData[i].endTime;
               // trip["startLoc"] = startCities[i];
               // trip["endLoc"] = endCities[i];

                rows.push([trip.id, trip.vehicleId, trip.startTime, trip.endTime])
                console.log(trip);
            };

            console.log(lonS, latS);
            //console.log(dataId);
            console.log(tableData);

        })
        getStartCity();
        getEndCity();

    }, [])

    const getStartCity = () => {

        for (let i = 0; i < lonS.length; i++) {
            var lng = lonS[i];
            var lat = latS[i];
            axios.get(`https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`).then((response) => {
                startCities.push(response.data.features[0].place_name);
            })
        }
        console.log(startCities);
    }

    const getEndCity = () => {
        for (let i = 0; i < lonE.length; i++) {
            var lng = lonE[i];
            var lat = latE[i];
            axios.get(`https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${accessToken}`).then((response) => {
                endCities.push(response.data.features[0].place_name);
            })

        }
        console.log(endCities);
    }

    //useEffect(() => {

    //})



    return (

        <DataGrid
            rows={rows}
            columns={columns}
            pageSize={10}
            rowsPerPageOptions={[10]}
            checkboxSelection={false}
        />
        //<div></div>

    )
}



export default TripCon;