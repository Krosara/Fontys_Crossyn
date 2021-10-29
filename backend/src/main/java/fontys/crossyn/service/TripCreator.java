package fontys.crossyn.service;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.ZonedDateTime;
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
    /*public ArrayList<Trip> addPacketToTrip(Packet currPacket, ArrayList<Trip> currTrips){
        Trip t = currTrips.get(currTrips.size()-1);
        if(t.isFinished()){
            t = new Trip(currPacket.getVehicleId());
            currTrips.add(t);
        }
        t.AddPacket(currPacket);
        if(currPacket.getIgnition() == IgnitionStates.FALSE){
            t.finishTrip();
        }
        else{
            currTrips.set(currTrips.size()-1, t);

        }
        return currTrips;
    }*/
    public boolean isNewTrip(ZonedDateTime time1, ZonedDateTime time2){
        long difference = Duration.between(time2, time1).toSeconds();
        if(difference >= 300){
            return true;
        }
        return false;
    }
    public HashMap<String, ArrayList<Trip>> createTrips(ArrayList<Packet> packets) {

        //initialize hashmap
        HashMap<String, ArrayList<Trip>> trips = new HashMap<String, ArrayList<Trip>>();
        ArrayList<Trip> currTrips = new ArrayList<Trip>();
        //starts first trip with first packet
        Packet currPacket = packets.get(0);
        Trip t = new Trip(currPacket.getVehicleId());
        t.addPacket(currPacket);
        currTrips.add(t);
        trips.put(currPacket.getVehicleId(), currTrips);

        for(int i = 1 ; i < packets.size(); i ++){
            //define current trip depending on packet
            currPacket = packets.get(i);
            if(trips.containsKey(currPacket.getVehicleId())){
                currTrips = trips.get(currPacket.getVehicleId());
            }
            else{
                currTrips = new ArrayList<Trip>();
                Trip newTrip = new Trip(currPacket.getVehicleId());
                newTrip.addPacket(currPacket);
                currTrips.add(newTrip);
                trips.put(currPacket.getVehicleId(), currTrips);
            }
            Trip lastTrip = currTrips.get(currTrips.size()-1);
            Packet lastPacket = lastTrip.getLast();
            if(isNewTrip(currPacket.getDate(), lastPacket.getDate())){
                //finish last trip and create new
                lastTrip.finishTrip();
                currTrips.set(currTrips.size()-1, lastTrip);
                t = new Trip(currPacket.getVehicleId());
                t.addPacket(currPacket);
                currTrips.add(t);
            }
            else{
                lastTrip.addPacket(currPacket);
                currTrips.set(currTrips.size()-1, lastTrip);
            }
            trips.replace(lastPacket.getVehicleId(), currTrips);
        }
        return trips;
    }

    /*public HashMap<String, ArrayList<Trip>> createTrips(ArrayList<Packet> packets){
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
        for(int j  = index; j < packets.size(); j++){
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
    }*/
}
