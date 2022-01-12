package fontys.crossyn.service;

import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TripEnrichment {

    public Trip addAvrgAndTopSpeed(Trip trip){

        List<Packet> packets = trip.getPackets();
        int speed;
        int sum = 0;
        int topspeed = 0;

        for (Packet packet: packets) {
            speed = packet.getSpeed();
            sum += speed;

            if (topspeed < speed){
                topspeed = speed;
            }
        }

        int averageSpeed = sum / packets.size();

        trip.setTopSpeed(topspeed);
        trip.setAverageSpeed(averageSpeed);
        return trip;
    }



}
