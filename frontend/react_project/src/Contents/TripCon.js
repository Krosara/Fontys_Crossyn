import React from 'react';
import axios from 'axios';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

function TripCon() {
  const tripID = [];

  React.useEffect(() => {
    axios.get(baseURL).then((response) => {
      response.data.forEach((element) => {
        tripID.push(element._id);
      });
      console.log(tripID);
    });
  }, []);

  return (
    <div className="VehicleInfo">
      <h1>Trip Info</h1>
      <h2>
        Location: 5761BW Bakel, Van de Poelstraat
        <br /> Last Used: 24/11/2021
        <br />
        <br />
        Average Score: 🌟🌟🌟🌟⭐ <br /> Distance Driven: 1102.2 km <br />
      </h2>
    </div>
  );
}
export default TripCon;
