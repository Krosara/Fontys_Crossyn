import vehicle from './img/vehicle.png';
import VehicleCon from './Contents/VehicleCon'

function Vehicle() {


  return (
    <div className="App">
      <header className="App-header">
        <img src={vehicle}  className="App-logo" alt="logo" />
      </header>
      <VehicleCon ></VehicleCon>
    </div>     
  );
  
}

export default Vehicle;
