package fontys.crossyn.service;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileReader;

import com.google.gson.*;
import fontys.crossyn.model.Packet;

public class JSONReader {

    public JSONReader(){

    }
    // Select JSON file to read
    public boolean selectJson(){

        final JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("JSON file", "json");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                FileReader reader = new FileReader(selectedFile);
                Gson gson = new Gson();
                Packet[] packets = gson.fromJson(reader, Packet[].class);

                long total = 0;
                long lastPacketTime = 0;
                for(int i = 0; i < packets.length-1; i ++){
                    long diff = packets[i+1].getDateTime().getTime() - packets[i].getDateTime().getTime();
                    total+=(diff/(1000%60));
                }

                System.out.println(total/5119);
                System.out.println(packets[0]);
                System.out.println(packets[1]);
                System.out.println(packets[2]);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
        return false;
    }
}
