package fontys.crossyn.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


public class Packet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vehicleId;
    @Embedded
    private Location location;
    private ZonedDateTime date;
    private int speed;
    private int speedLimit;
    private int roadType;
    @Nullable
    private Boolean ignition;

    public Packet(String vehicleId, double lat, double lon, int alt, ZonedDateTime date, int speed, int speedLimit, int roadType, Boolean ignition){
        this.vehicleId = vehicleId;
        this.location = new Location(lat,lon,alt);
        this.date = date;
        this.speed = speed;
        this.speedLimit = speedLimit;
        this.roadType = roadType;
        this.ignition = ignition;
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
