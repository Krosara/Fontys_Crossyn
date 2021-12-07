import React from 'react';
import axios from 'axios';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

function TripCon()
{

    const tripID = [];

    React.useEffect(() => {
        axios.get(baseURL).then((response) => {
            response.data.forEach(element => {
                tripID.push(element._id)
            });
            console.log(tripID);
        })
        }, [])

        //const tripInfo = this.state.tripInfo
        return(
            <div className="VehicleInfo">
                    <h1>Trip Info</h1>
                    {/* <h3>Week 22 Avg: {marsInfo.temperature}°C</h3> */}
                    <h2>Trip ID: {tripID[0]}<br/> Last Used: 24/11/2021<br/><br/>Average Score: 🌟🌟🌟🌟⭐ <br/> Distance Driven: 1102.2 km <br/></h2>
                    {/* {tripInfo.map(info => <h2>SOL {info.dayID}<br/>{info.time }<br/><br/>{info.temperature}°C <br/> Humidity: {info.humidity}% <br/></h2>)} */}
            </div>      
        )
}
export default TripCon;