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

@Data
@Document
public class Packet {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vehicleId;
    @Embedded
    private Location location;
    private ZonedDateTime date;
    private int speed;
    private int speedLimit;
    private int roadType;
    private IgnitionStates ignition;



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
}
