package fontys.crossyn.repository.JPA;

import fontys.crossyn.model.Trip;

public interface ITripDAL {
    Trip getTripByVehicleID(Long vehicleID);

}
