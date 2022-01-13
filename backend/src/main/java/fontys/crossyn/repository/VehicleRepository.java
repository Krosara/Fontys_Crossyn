package fontys.crossyn.repository;

import fontys.crossyn.model.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    List<Vehicle> getVehicleByFleetId(int id);
}
