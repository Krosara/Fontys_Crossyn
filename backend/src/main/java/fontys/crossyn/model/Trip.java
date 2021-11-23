package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripID;
    private String vehicleID;
    @Getter
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    @OneToMany(mappedBy="trip")
    private List<Packet> packets;

    public Trip(String vehicleID) {

        this.vehicleID = vehicleID;
        this.packets = new ArrayList<Packet>();
        this.endTime = null;
    }

    public Trip() {

    }

    public void addPacket(Packet packet){
        if(packets.size() == 0 || !packet.equals(getLast())){
            this.packets.add(packet);
        }
        //this.packets.add(packet);
    }

    public void finishTrip(){
        this.startTime = packets.get(0).getDate();
        this.endTime = packets.get(packets.size()-1).getDate();
    }

    public boolean isFinished(){
        if(this.endTime == null ){
            return false;
        }
        return true;
    }

    public Packet getLast(){
        return packets.get(packets.size()-1);
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripID=" + tripID +
                ", vehicleID='" + vehicleID + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", packet amount=" + packets.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return vehicleID.equals(trip.getVehicleID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleID);
    }
}
