package fontys.crossyn;

import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.TripCreator;
import fontys.crossyn.service.JSONReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class CrossynApplication {


    public static void main(String[] args) {

        //IOService ioService = new IOService();
        //ioService.convertTxtToJson();

        JSONReader reader = new JSONReader();
        TripCreator tripCreator = new TripCreator();

        ArrayList<Packet> packetList = reader.readJson();

        HashMap<String, ArrayList<Trip>> trips = tripCreator.createTrips(packetList);

       // System.out.println(tripCreator.isNewTrip(packetList.get(0).getDate(), packetList.get(1).getDate()));
       // System.out.println(tripCreator.isNewTrip(packetList.get(1).getDate(), packetList.get(2).getDate()));
        System.out.println(tripCreator.isNewTrip(packetList.get(975).getDate(), packetList.get(976).getDate()));
        System.out.println(tripCreator.isNewTrip(packetList.get(976).getDate(), packetList.get(977).getDate()));
        System.out.println(tripCreator.isNewTrip(packetList.get(977).getDate(), packetList.get(978).getDate()));
        System.out.println(tripCreator.isNewTrip(packetList.get(978).getDate(), packetList.get(979).getDate()));
       // System.out.println(tripCreator.isNewTrip(packetList.get(2).getDate(), packetList.get(4000).getDate()));

        ArrayList<Trip> currTrips= trips.get(packetList.get(0).getVehicleId());



        SpringApplication.run(CrossynApplication.class, args);
    }



}
