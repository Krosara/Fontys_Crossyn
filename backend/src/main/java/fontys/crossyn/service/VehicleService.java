package fontys.crossyn.service;

import fontys.crossyn.model.*;
import fontys.crossyn.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehiclesByFleetID(int id) {
        return vehicleRepository.getVehicleByFleetId(id);
    }
}
