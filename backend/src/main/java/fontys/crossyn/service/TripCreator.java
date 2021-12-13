package fontys.crossyn.service;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.repository.PacketRepository;
import fontys.crossyn.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TripCreator {

    @Autowired
    TripRepository tripRepository;

    public List<Trip> GetTrips(){
        List<Trip> trips = tripRepository.findAll();

        return trips;
    }


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
    public boolean isNewTrip(Packet packet1, Packet packet2){
        /*if(packet2.getIgnition() == IgnitionStates.FALSE){
            return true;
        }*/
        ZonedDateTime time1 = packet1.getDate();
        ZonedDateTime time2 = packet2.getDate();
        long difference = Duration.between(time2, time1).toSeconds();
        return difference >= 300;
    }
    //Finishes the last trip in the array
    private ArrayList<Trip> finishLastTrip(ArrayList<Trip> trips){
        Trip lastTrip = trips.get(trips.size()-1);
        lastTrip.finishTrip();
        trips.set(trips.size()-1, lastTrip);
        return trips;
    }

    //Loops through all vehicles' trips in order to finish them
    private HashMap<String, ArrayList<Trip>> finishTrips(HashMap<String, ArrayList<Trip>> trips){
        HashMap<String, ArrayList<Trip>> finished = new HashMap<String, ArrayList<Trip>>();
        for (Map.Entry<String, ArrayList<Trip>> entry : trips.entrySet()){
                String vehicleId = entry.getKey();
                ArrayList<Trip> currTrips = finishLastTrip(entry.getValue());
                finished.put(vehicleId, currTrips);
            }
        return finished;
    }
    public HashMap<String, ArrayList<Trip>> createTrips(ArrayList<Packet> packets) {

        HashMap<String, ArrayList<Trip>> trips = new HashMap<String, ArrayList<Trip>>();
        ArrayList<Trip> currTrips = new ArrayList<Trip>();
        
        //starts first trip with first packet
        Packet currPacket = packets.get(0);
        Trip t = new Trip(currPacket.getVehicleId());
        t.addPacket(currPacket);
        currTrips.add(t);
        trips.put(currPacket.getVehicleId(), currTrips);

        Trip lastTrip = t;
        Packet lastPacket = currPacket;
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
            lastTrip = currTrips.get(currTrips.size()-1);
            lastPacket = lastTrip.getLast();
            if(isNewTrip(currPacket, lastPacket)){
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
        /*lastTrip.finishTrip();
        currTrips.set(currTrips.size()-1, lastTrip);
        trips.replace(lastPacket.getVehicleId(), currTrips);

        for (Map.Entry<String, ArrayList<Trip>> entry : trips.entrySet()){
            for(Trip  trip : entry.getValue()){
                tripRepository.save(trip);
            }
        }*/
        return finishTrips(trips);
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
