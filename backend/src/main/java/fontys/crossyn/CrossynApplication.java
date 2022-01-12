package fontys.crossyn;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import fontys.crossyn.dto.UserDTO;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.model.User;
import fontys.crossyn.repository.PacketRepository;
import fontys.crossyn.repository.UserRepository;
import fontys.crossyn.service.*;
import org.modelmapper.ModelMapper;
import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


@SpringBootApplication
public class CrossynApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public JSONReader reader(){
        return new JSONReader();
    }

    public static void main(String[] args) {

        //IOService ioService = new IOService();
        //ioService.convertTxtToJson();

        JSONReader reader = new JSONReader();
        TripCreator tripCreator = new TripCreator();
        TripMerger tripMerger = new TripMerger();

        ArrayList<Packet> packetList = reader.readJsonFile();

        HashMap<String, ArrayList<Trip>> trips = tripCreator.createTrips(packetList);
        System.out.println(-1);
        //HashMap<String, ArrayList<Trip>> mergedTrips = tripMerger.mergeTrips(trips);

        ArrayList<Trip> currTrips= trips.get(packetList.get(0).getVehicleId());
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

        Logger logger = LoggerFactory.getLogger(CrossynApplication.class);
        logger.info("--------------");
        logger.info("--------------");
        logger.info("--------------");
        logger.info("--------------");
        logger.info("--------------");
        logger.info("--------------");
        logger.info("Logging Starts");


        for(Trip t: currTrips){
            logger.info(t.toString());
            logger.info("First Packet: " +t.getPackets().get(0));
            logger.info("Last Packet: " + t.getPackets().get(t.getPackets().size()-1));
            logger.info("Top Speed: " + t.getTopSpeed());
            logger.info("Average Speed: " + t.getAverageSpeed());

            logger.info("--------------");
        }
        logger.info("Total Trips: " + currTrips.stream().count());



        logger.info("Application has been fully build.");
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserService userService) {
//        return args -> {
//            userService.createUser(new UserDTO("test", "test","test", "test@gmail.com"));
//        };
//    }

//    @Bean
//    CommandLineRunner commandLineRunner(PacketRepository pr, JSONReader reader) {
//        return args -> {
//            ArrayList<Packet> packetList = reader.readJsonFile();
//
//            for (Packet p : packetList) {
//                pr.insert(p);
//            }
//        };
//
//    }

}
