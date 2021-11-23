package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Packet {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String vehicleId;
    @Embedded
    private Location location;
    private ZonedDateTime date;
    private int speed;
    private int speedLimit;
    private int roadType;
    private IgnitionStates ignition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_trip_id", unique = true)
    private Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }


    public Packet(String vehicleId, double lat, double lon, int alt, ZonedDateTime date, int speed, int speedLimit, int roadType, IgnitionStates ignition){
        this.vehicleId = vehicleId;
        this.location = new Location(lat,lon,alt);
        this.date = date;
        this.speed = speed;
        this.speedLimit = speedLimit;
        this.roadType = roadType;
        this.ignition = ignition;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public IgnitionStates getIgnition() {
        return ignition;
    }
    public ZonedDateTime getDate() {
        return date;
    }
    @Override
    public String toString() {
        return "Packet{" +
                "id=" + id +
                ", vehicleId='" + vehicleId + '\'' +
                ", location=" + location +
                ", date=" + date +
                ", speed=" + speed +
                ", speedLimit=" + speedLimit +
                ", roadType=" + roadType +
                ", ignition=" + ignition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packet packet = (Packet) o;
        return (date.equals(packet.date)/* && location.equals(packet.location)*/);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
