package fontys.crossyn;

import fontys.crossyn.controller.TripController;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.IOService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrossynApplication {


    public static void main(String[] args) {

        IOService ioService = new IOService();
        ioService.convertTxtToJson();

        Packet packet1 = new Packet(1,"1",null,null,null,null,null,true);
        Packet packet2 = new Packet(2,"1",null,null,null,null,null,null);
        Packet packet3 = new Packet(3,"2",null,null,null,null,null,null);
        Packet packet4 = new Packet(4,"1",null,null,null,null,null,false);
        Packet packet5 = new Packet(5,"2",null,null,null,null,null,true);

        List<Packet> packetList = new ArrayList<Packet>();
        packetList.add(packet1);
        packetList.add(packet2);
        packetList.add(packet3);
        packetList.add(packet4);
        packetList.add(packet5);

        TripController tripController = new TripController();
        tripController.CreateTrip(packetList);


        SpringApplication.run(CrossynApplication.class, args);
    }



}
