package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Trip {

    private int tripID;
    @Getter
    private String vechicle; //should be a class later.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return vechicle.equals(trip.vechicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vechicle);
    }

    private Date time;
    private List<Packet> packets;

    public Trip(int tripID, String vechicleID, Date time) {
        this.tripID = tripID;
        this.vechicle = vechicleID;
        this.time = time;
        this.packets = new ArrayList<Packet>();
    }


    public void AddPacket(Packet packet){
        this.packets.add(packet);
    }


}
