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
