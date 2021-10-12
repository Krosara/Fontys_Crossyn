package fontys.crossyn.controller;

import fontys.crossyn.model.Packet;
import fontys.crossyn.service.PacketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    ArrayList<String> Packets = new ArrayList<String>(); //PacketController Packages
    ArrayList<String> Trip1 = new ArrayList<String>(); //PacketController Packages

    String LastdateTime;

    String start_date = "10-01-2018 01:10:20";
    String end_date = "10-06-2020 06:30:50";

    for (Packet packet : Packets)
    {
        if(packet.vehicle == "1") //user.vehicleID
        {
            if (packet.ignition == true)
            {
                long difference = findDifference(start_date, end_date);
                if (difference > 3) // & CHECK ROADTYPE AND SPEED
                {

                }
                Trip1.add(packet);
            }
            if (packet.ignition == false)
            {

            }
            //LastdateTime = packet.dateTime;
        }

    }

    static long findDifference(String start_date, String end_date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                    = d2.getTime() - d1.getTime();

            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days
            long difference_In_Seconds
                    = (difference_In_Time
                    / 1000)
                    % 60;

            long difference_In_Minutes
                    = (difference_In_Time
                    / (1000 * 60))
                    % 60;

            long difference_In_Hours
                    = (difference_In_Time
                    / (1000 * 60 * 60))
                    % 24;

            long difference_In_Years
                    = (difference_In_Time
                    / (1000l * 60 * 60 * 24 * 365));

            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;

            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
            System.out.println(
                    difference_In_Years
                            + " years, "
                            + difference_In_Days
                            + " days, "
                            + difference_In_Hours
                            + " hours, "
                            + difference_In_Minutes
                            + " minutes, "
                            + difference_In_Seconds
                            + " seconds");

            return difference_In_Minutes;
        }

        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
