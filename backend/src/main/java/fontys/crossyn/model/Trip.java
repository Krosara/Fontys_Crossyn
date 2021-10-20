package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Trip {

    private int tripID;
    private String vehicleID;
    @Getter
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private List<Packet> packets;

    public Trip(String vehicleID) {
        this.vehicleID = vehicleID;
        this.packets = new ArrayList<Packet>();
    }

    public void AddPacket(Packet packet){
        this.packets.add(packet);
    }

    public void finishTrip(){
        this.startTime = packets.get(0).getDate();
        this.endTime = packets.get(packets.size()-1).getDate();
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public String getVehicleID() {
        return vehicleID;
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
