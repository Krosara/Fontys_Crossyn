import { useEffect, useState, React } from 'react';
import axios from 'axios';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

function TripCon() {

    const [tripID, setTripID] = useState([]);
    const kur = [];
    var lonS = [];
    var latS = [];
    var lonE = [];
    var latE = [];
    var data = [];
    var cities = [];

    useEffect(async () => {
        await axios.get(baseURL).then((response) => {
            for (var i = 0; i < response.data.length; i++) {
                data = response.data[i];
                var dataSize = data.packets.length;
                lonS.push([data.packets[0].location.lon])
                latS.push([data.packets[0].location.lat])
                lonE.push([data.packets[dataSize - 1].location.lon])
                latE.push([data.packets[dataSize - 1].location.lat])
                //tripLocE.push([data.packets[dataSize - 1].location.lon, data.packets[dataSize - 1].location.lat])
                //data.packets.forEach((element) => tripLoc.push([element.location.lon, element.location.lat]));
            }
            console.log(lonS, latS);

        })
        getCity();

    }, [])

    /*useEffect (async () => {
        await axios.get(baseURL).then((response) => {
            response.data.forEach(element => {
                kur.push(element._id)
            })
            setTripID(kur[0]);
            console.log(tripID);
        })
        }, [])*/



    function getCity() {
        var xhr = new XMLHttpRequest();

        for (let i = 0; i < lonS.length; i++) {
            var lng = lonS[i];
            var lat = latS[i];
            xhr.open('GET', "https://us1.locationiq.com/v1/reverse.php?key=pk.9a909d40e4aece956d37017eaf13a43f&lat=" +
                lat + "&lon=" + lng + "&format=json", true);
            xhr.send();
            xhr.onreadystatechange = processRequest;
            xhr.addEventListener("readystatechange", processRequest, false);

            function processRequest(e) {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var response = JSON.parse(xhr.responseText);
                    var city = response.address.city;
                    cities.push(response.address.city);
                    console.log(city);
                    //return;
                }
                
            }
        }
        console.log(cities);
    }


    return (
        <div className="VehicleInfo">
            <h1>Trip Info</h1>
            {/* <h3>Week 22 Avg: {marsInfo.temperature}°C</h3> */}
            <h2>Trip ID: { }<br /> Last Used: 24/11/2021<br /><br />Average Score: 🌟🌟🌟🌟⭐ <br /> Distance Driven: 1102.2 km <br /></h2>
            {/* {tripInfo.map(info => <h2>SOL {info.dayID}<br/>{info.time }<br/><br/>{info.temperature}°C <br/> Humidity: {info.humidity}% <br/></h2>)} */}
        </div>
    )
}
export default TripCon;