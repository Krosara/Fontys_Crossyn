package fontys.crossyn.service;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TripCreator {


   /* public HashMap<String, ArrayList<Packet>> packetSplitter(ArrayList<Packet> packets){
        HashMap<String, ArrayList<Packet>> trips = new HashMap<String, ArrayList<Packet>>();
        for(Packet p : packets){

        }
    }*/
    public TripCreator(){

    }
    public ArrayList<Trip> addPacketToTrip(Packet currPacket, ArrayList<Trip> currTrips){
        Trip t = currTrips.get(currTrips.size()-1);
        t.AddPacket(currPacket);
        if(currPacket.getIgnition() == IgnitionStates.FALSE){
            t.finishTrip();
            currTrips.add(new Trip(currPacket.getVehicleId()));
        }
        else{
            currTrips.set(currTrips.size()-1, t);

        }
        return currTrips;
    }

    public HashMap<String, ArrayList<Trip>> createTrips(ArrayList<Packet> packets){
        HashMap<String, ArrayList<Trip>> trips = new HashMap<String, ArrayList<Trip>>();
        int index = 0;
        for(int i = 0 ; i < packets.size(); i ++){
            Packet currPacket = packets.get(i);
            if(currPacket.getIgnition() == IgnitionStates.TRUE) {
                ArrayList<Trip> currTrips = new ArrayList<Trip>();
                currTrips.add(new Trip(currPacket.getVehicleId()));
                trips.put(currPacket.getVehicleId(), currTrips);
                index = i+1;
                break;
            }
        }
        for(int j = index; j < packets.size(); j++){
            Packet currPacket = packets.get(j);
            if(trips.containsKey(currPacket.getVehicleId())){
                ArrayList<Trip> currTrips = trips.get(currPacket.getVehicleId());
                trips.replace(currPacket.getVehicleId(), addPacketToTrip(currPacket, currTrips));
            }
            else{
                ArrayList<Trip> newList = new ArrayList<Trip>();
                newList.add(new Trip(currPacket.getVehicleId()));
                newList = addPacketToTrip(currPacket, newList);
                trips.put(currPacket.getVehicleId(), newList);
            }

        }
        return trips;
    }
}
