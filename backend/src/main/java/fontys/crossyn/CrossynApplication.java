package fontys.crossyn;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.TripCreator;
import fontys.crossyn.service.JSONReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class CrossynApplication {


    public static void main(String[] args) {

        //IOService ioService = new IOService();
        //ioService.convertTxtToJson();
//        JSONReader jsonReader = new JSONReader();
//        TripCreator tripCreator = new TripCreator();
//        File selectedFile = jsonReader.fileSelect();
//        FileReader reader = new FileReader(selectedFile);
//        Gson gson = new Gson();
//        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
//
//
//        ArrayList<Packet> packetList = reader.readJson(jsonArray);
//
//        HashMap<String, ArrayList<Trip>> trips = tripCreator.createTrips(packetList);
//
//
//
//        ArrayList<Trip> currTrips= trips.get(packetList.get(0).getVehicleId());



        SpringApplication.run(CrossynApplication.class, args);
    }



}
