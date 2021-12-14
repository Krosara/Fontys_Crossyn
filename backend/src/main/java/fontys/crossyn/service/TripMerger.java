package fontys.crossyn.service;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import fontys.crossyn.config.TripMergeConfig;
import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TripMerger {

    private final TripMergeConfig config = new TripMergeConfig();
    public TripMerger(){

    }

    public HashMap<String, ArrayList<Trip>> mergeTrips(HashMap<String, ArrayList<Trip>> trips){
        HashMap<String, ArrayList<Trip>> mergedTrips = new HashMap<String, ArrayList<Trip>>();

        for(Map.Entry<String, ArrayList<Trip>> entry: trips.entrySet()){
            String vehicleId = entry.getKey();
            ArrayList<Trip> currTrips = entry.getValue();
            for(int i = currTrips.size()-1; i > 0 ; i --) {
                Trip secondTrip = currTrips.get(i);
                Trip firstTrip = currTrips.get(i - 1);
                if (isSameTrip(firstTrip, secondTrip)) {
                    currTrips.remove(i);
                    currTrips.remove(i - 1);
                    Trip mergedTrip = mergeTrips(firstTrip, secondTrip);
                    currTrips.add(mergedTrip);
                }
            }
            mergedTrips.put(vehicleId, currTrips);
        }
        return mergedTrips;
    }

    private Trip mergeTrips(Trip trip1, Trip trip2){
        ArrayList<Packet> trip2Packets = trip2.getPackets();
        trip1.mergePackets(trip2Packets);
        return trip1;
    }

    private boolean isSameTrip(Trip firstTrip, Trip secondTrip){
        Packet lastPacket = firstTrip.getLast();
        Packet firstPacket = secondTrip.getFirst();
        System.out.println(lastPacket);
        System.out.println(firstPacket);
        System.out.println("--------");
        int totalPoints = totalPoints(lastPacket, firstPacket);
        System.out.println(totalPoints);
        if(totalPoints >= config.neededPoints){
            return true;
        }
        return false;
    }
    private int totalPoints(Packet lastPacket, Packet firstPacket){
        int points = 0;
        points += checkRoadType(lastPacket);
        points += checkIgnition(lastPacket, firstPacket);
        points += checkSpeedLimit(lastPacket);
        points += checkSpeed(lastPacket, firstPacket);
        return points;

    }
    private int checkRoadType(Packet lastPacket){
        int roadType = lastPacket.getRoadType();
        return config.roadTypePoints[roadType-1];
    }

    private int checkIgnition(Packet lastPacket, Packet firstPacket){
        int points = 0;
        if(lastPacket.getIgnition() == IgnitionStates.FALSE){
            points += config.ignitionFalsePoints;
        }
        if(firstPacket.getIgnition() == IgnitionStates.TRUE){
            points += config.ignitionTruePoints;
        }
        return points;
    }

    private int checkSpeedLimit(Packet lastPacket){
        int speedLimit = lastPacket.getSpeedLimit();
        if(speedLimit <= config.speedLimit){
            return config.speedLimitLowPoints;
        }
        return config.speedLimitHighPoints;
    }

    private int checkSpeed(Packet lastPacket, Packet firstPacket){
        int points = 0;
        int speedLastPacket = lastPacket.getSpeed();
        int speedFirstPacket = firstPacket.getSpeed();
        if(speedLastPacket > config.stoppingSpeed){
            points += config.endingSpeedHighPoints;
        }
        else{
            points += config.endingSpeedLowPoints;
        }

        if(speedFirstPacket > config.startingSpeed){
            return points += config.startingSpeedHighPoints;
        }
        return points += config.startingSpeedLowPoints;
    }
}
