package fontys.crossyn.controller;

import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.PacketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.*;

@RestController
@RequestMapping("/api/trip")
public class TripController {



    public List<Trip> CreateTrip(List<Packet> packets) {

        ArrayList<Trip> trips = new ArrayList<>();
        Trip newt;
        Boolean tripExists = false;
        for (Packet p : packets) {
            if(trips.contains(p.getVehicleId())){
                t.AddPacket(p);
                tripExists = true;
            }


            }
            if (tripExists == false) {
                newt = new Trip(1, p.getVehicleId(), null);
                newt.AddPacket(p);
                trips.add(newt);
            }
            tripExists = false;
        }
        System.out.println(trips);





        return null;
    }
//        List<String> carIDs = new ArrayList<>();
//
//        for(Packet p : packets){
//            if (!carIDs.contains(p.getVehicleId()))
//           carIDs.add(p.getVehicleId());
//
//
//        }
//
//        List<String> uniqueCarIDs = new ArrayList<String>(new HashSet<String>(carIDs));
//        System.out.println(uniqueCarIDs);
//
//        List<Trip> CarTrips= new ArrayList<>();
//        Trip trip = new Trip(1, null, null, new ArrayList<Packet>());
//
//        int x = 0;
//        for (Packet p: packets){
//            if (p.getVehicleId() == carIDs.get(x)){
//                trip.AddPacket(p);
//
//                if(p.getIgnition() != false){
//
//                }
//
//            }
//
//        }
//
//        return null;
//        for (Packet packet : packets) {
//            if (packet.getVehicleId() == "1") //user.vehicleID
//            {
//                if (packet.isIgnition() == true) {
//                    long difference = findDifference(start_date, end_date);
//                    if (difference > 3) // & CHECK ROADTYPE AND SPEED
//                    {
//
//                    }
//                    Trip1.add(packet);
//                }
//                if (packet.ignition == false) {
//
//                }
//                //LastdateTime = packet.dateTime;
//            }
//
//        }
//
//    }


//        static long findDifference (String start_date, String end_date)
//        {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//            try {
//                Date d1 = sdf.parse(start_date);
//                Date d2 = sdf.parse(end_date);
//
//                // Calucalte time difference
//                // in milliseconds
//                long difference_In_Time
//                        = d2.getTime() - d1.getTime();
//
//                // Calucalte time difference in
//                // seconds, minutes, hours, years,
//                // and days
//                long difference_In_Seconds
//                        = (difference_In_Time
//                        / 1000)
//                        % 60;
//
//                long difference_In_Minutes
//                        = (difference_In_Time
//                        / (1000 * 60))
//                        % 60;
//
//                long difference_In_Hours
//                        = (difference_In_Time
//                        / (1000 * 60 * 60))
//                        % 24;
//
//                long difference_In_Years
//                        = (difference_In_Time
//                        / (1000l * 60 * 60 * 24 * 365));
//
//                long difference_In_Days
//                        = (difference_In_Time
//                        / (1000 * 60 * 60 * 24))
//                        % 365;
//
//                // Print the date difference in
//                // years, in days, in hours, in
//                // minutes, and in seconds
//                System.out.println(
//                        difference_In_Years
//                                + " years, "
//                                + difference_In_Days
//                                + " days, "
//                                + difference_In_Hours
//                                + " hours, "
//                                + difference_In_Minutes
//                                + " minutes, "
//                                + difference_In_Seconds
//                                + " seconds");
//
//                return difference_In_Minutes;
//            }
//
//            // Catch the Exception
//            catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
}
