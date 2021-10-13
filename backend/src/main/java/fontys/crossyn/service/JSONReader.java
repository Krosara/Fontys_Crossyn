package fontys.crossyn.service;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.google.gson.*;
import fontys.crossyn.model.Packet;

public class JSONReader {

    public JSONReader(){

    }

    public boolean selectJson(){

        // Selection of JSON file
        final JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "\\src\\main\\resources\\");
        FileFilter filter = new FileNameExtensionFilter("JSON file", "json");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION) {
            try {

                //Reading of JSON file
                File selectedFile = fileChooser.getSelectedFile();
                FileReader reader = new FileReader(selectedFile);
                Gson gson = new Gson();
                JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

                ArrayList<Packet> packets = new ArrayList<Packet>();
                for(JsonElement element: jsonArray){
                    JsonObject obj = element.getAsJsonObject();

                    String vehicleId = obj.get("vehicleId").getAsString();
                    double lat = obj.get("lat").getAsDouble();
                    double lon = obj.get("lon").getAsDouble();
                    int alt = obj.get("alt").getAsInt();
                    //date formatting
                    String dateString = (obj.get("dateTime").getAsString());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
                    ZonedDateTime date = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

                    int speed = obj.get("speed").getAsInt();
                    int speedLimit = obj.get("speedLimit").getAsInt();
                    int roadType = obj.get("roadType").getAsInt();
                    Boolean ignition = null;
                    if(obj.has("ignition")){
                        ignition = obj.get("ignition").getAsBoolean();
                    }
                    Packet dataPacket = new Packet(vehicleId, lat, lon, alt, date, speed, speedLimit, roadType, ignition);
                    packets.add(dataPacket);
                }
                System.out.println(packets.size());
                System.out.println(packets.get(0));
                System.out.println(packets.get(1));
                System.out.println(packets.get(2));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
        return false;
    }
}
