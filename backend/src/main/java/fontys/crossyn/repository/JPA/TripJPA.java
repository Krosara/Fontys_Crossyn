package fontys.crossyn.repository.JPA;

import fontys.crossyn.model.Trip;
import fontys.crossyn.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripJPA implements ITripDAL {

    @Autowired
    TripRepository repo;


    @Override
    public Trip getTripByVehicleID(Long vehicleID) {
        return repo.getTripByVehicleID(vehicleID);
    }
}
