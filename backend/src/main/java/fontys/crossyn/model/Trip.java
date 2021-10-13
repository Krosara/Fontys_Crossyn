package fontys.crossyn.model;

import lombok.Setter;

import java.util.Date;
import java.util.List;


public class Trip {

    private int tripID;
    private String vechicle; //should be a class later.
    private Date time;
    private List<Packet> packets;

    public Trip(int tripID, String vechicleID, Date time, List<Packet> packets) {
        this.tripID = tripID;
        this.vechicle = vechicleID;
        this.time = time;
        this.packets = packets;
    }


    public void AddPacket(Packet packet){
        this.packets.add(packet);
    }


}
