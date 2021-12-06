package fontys.crossyn.service;

import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    public List<Trip> GetTrips(){
        List<Trip> trips = tripRepository.findAll();

        return trips;
    }

    public void CreateTrips(ArrayList<Packet> packets){
        TripCreator tripCreator = new TripCreator();

        HashMap<String, ArrayList<Trip>> trips = tripCreator.createTrips(packets);

        for (Map.Entry<String, ArrayList<Trip>> entry : trips.entrySet()) {
            for (Trip trip: entry.getValue()) {
                tripRepository.insert(trip);
            }
        }

    }

    public void DeleteTrip(String tripId){
       tripRepository.deleteById(tripId);
    }
}
