package fontys.crossyn.service;

import fontys.crossyn.model.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TripMerger {

    public TripMerger(){

    }

    public HashMap<String, ArrayList<Trip>> mergeTrips(HashMap<String, ArrayList<Trip>> trips){
        HashMap<String, ArrayList<Trip>> mergedTrips = new HashMap<String, ArrayList<Trip>>();

        for(Map.Entry<String, ArrayList<Trip>> entry: trips.entrySet()){
            String vehicleId = entry.getKey();
            ArrayList<Trip> currTrips = entry.getValue();
            for(Trip t: currTrips){

            }
        }
        return trips;
    }
}
