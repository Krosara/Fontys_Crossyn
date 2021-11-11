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

        ArrayList<Trip> currTrips= trips.get(packetList.get(0).getVehicleId());

        for(Trip t: currTrips){
            System.out.println(t);
            System.out.println(t.getPackets().get(0));
            System.out.println(t.getPackets().get(t.getPackets().size()-1));
            System.out.println();
        }



        SpringApplication.run(CrossynApplication.class, args);
    }



}
