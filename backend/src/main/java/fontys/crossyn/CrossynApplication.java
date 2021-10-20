package fontys.crossyn;

import fontys.crossyn.model.Packet;
import fontys.crossyn.service.JSONReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrossynApplication {


    public static void main(String[] args) {

        //IOService ioService = new IOService();
        //ioService.convertTxtToJson();

        JSONReader reader = new JSONReader();
        reader.readJson();

        List<Packet> packetList = new ArrayList<Packet>();
        TripController tripController = new TripController();
        tripController.CreateTrip(packetList);


        SpringApplication.run(CrossynApplication.class, args);
    }



}
