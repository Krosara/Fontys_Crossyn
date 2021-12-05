import trips from './img/trips.png';
import TripCon from './Contents/TripCon'
import Map1 from './Components/Map'


function Trips() {
  
  return (
    <div className="App">
      <header className="mars-header">
        <img src={trips}  className="App-logo" alt="logo" />
      </header>
      <TripCon></TripCon>
      <Map1></Map1>
    </div>     
  );
}

export default Trips;
