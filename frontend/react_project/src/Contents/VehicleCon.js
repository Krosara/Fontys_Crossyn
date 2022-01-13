import React from 'react';
import axios from 'axios';

class VehicleCon extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      vehicleInfo: [],
    };
  }

  componentDidMount() {
    axios.get('http://localhost:3000/api/vehicles/getfromfleetid/1').then((response) => {
      this.setState({
        vehicleInfo: response.data,
      });
      console.log(response.data);
    });
  }
  getVehiclesbyFleetID(fleetID) {
    axios.get('http://localhost:3000/api/vehicles/getfromfleetid/' + fleetID).then((response) => {
      this.setState({
        vehicleInfo: response.data,
      });
      console.log(response.data);
    });
  }



  render() {
    const { vehicleInfo } = this.state.vehicleInfo;

    <input onChange={(e) => {this.getVehiclesbyFleetID(e.target.value)}} placeholder="Lookup vehicle by fleet id..."></input>

    return (
      <div class="Vehicle Info">
        <h1>Vehicle(s) Info</h1>
        <h2>
          Owner: AJW Rutjens
          <br /> Driven: 50210 km
          <br />
          <br />
          Average Performance Score: 🌟🌟🌟⭐⭐ <br /> Last Seen: 5761BW Bakel,
          Van de Poelstraat <br />
        </h2>
      </div>
    );
  }
}
export default VehicleCon;
