import MapPage from './pages/MapPage';
import LandingPage from './pages/LandingPage';
import ProfilePage from './pages/ProfilePage';
import TripsPage from './pages/TripsPage';
import Navbar from './Components/Navbar';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import MeasureDistanceTestPAGE from './pages/MeasureDistanceTestPAGE';


const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<LandingPage />}></Route>
        <Route exact path="/test" element={<MeasureDistanceTestPAGE />}></Route>
        <Route path="/map" element={<MapPage />}></Route>
        <Route path="/profile" element={<ProfilePage />}></Route>
        <Route path="/trips" element={<TripsPage />}></Route>
        <Route path="/login" element={<LoginPage />}></Route>
      </Routes>
    </Router>
  );
};

export default App;
