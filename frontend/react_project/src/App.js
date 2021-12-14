import MapPage from './pages/MapPage';
import LandingPage from './pages/LandingPage';
import ProfilePage from './pages/ProfilePage';
import TripsPage from './pages/TripsPage';
import Navbar from './Components/Navbar';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<LandingPage />}></Route>
        <Route path="/map" element={<MapPage />}></Route>
        <Route path="/profile" element={<ProfilePage />}></Route>
        <Route path="/trips" element={<TripsPage />}></Route>
      </Routes>
    </Router>
  );
};

export default App;
