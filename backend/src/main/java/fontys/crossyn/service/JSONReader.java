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
import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Packet;

public class JSONReader {

    public JSONReader(){

    }

    //File selection
    private File fileSelect(){
        final JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "\\src\\main\\resources\\");
        FileFilter filter = new FileNameExtensionFilter("JSON file", "json");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
    // Date Formatting
    private ZonedDateTime formatDate(String dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
        ZonedDateTime date = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return date;
    }
    // Packet printing
    private void printPackets(ArrayList<Packet> packets){
        System.out.println(packets.size());
        System.out.println(packets.get(0));
        System.out.println(packets.get(1));
        System.out.println(packets.get(2));
    }

    public ArrayList<Packet> readJson(){
        File selectedFile = fileSelect();
        if(selectedFile != null) {
            try {
                //Reading of JSON file
                FileReader reader = new FileReader(selectedFile);
                Gson gson = new Gson();
                JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

                ArrayList<Packet> packets = new ArrayList<Packet>();

                for(JsonElement element: jsonArray) {
                    JsonObject obj = element.getAsJsonObject();
                    String vehicleId = obj.get("vehicleId").getAsString();
                    double lat = obj.get("lat").getAsDouble();
                    double lon = obj.get("lon").getAsDouble();
                    int alt = obj.get("alt").getAsInt();
                    ZonedDateTime date = formatDate(obj.get("dateTime").getAsString());
                    int speed = obj.get("speed").getAsInt();
                    int speedLimit = obj.get("speedLimit").getAsInt();
                    int roadType = obj.get("roadType").getAsInt();
                    IgnitionStates ignition = IgnitionStates.NULL;
                    if (obj.has("ignition")) {
                        if(obj.get("ignition").getAsBoolean()){
                            ignition = IgnitionStates.TRUE;
                        }
                        else{
                            ignition = IgnitionStates.FALSE;
                        }

                    }
                    Packet dataPacket = new Packet(vehicleId, lat, lon, alt, date, speed, speedLimit, roadType, ignition);
                    packets.add(dataPacket);
                }
                //printPackets(packets);
                return packets;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
        return null;
    }
}
