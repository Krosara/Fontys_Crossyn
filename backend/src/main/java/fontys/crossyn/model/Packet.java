package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Packet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vehicleId;
    @Embedded
    private Location location;
    private Date dateTime;
    private int speed;
    private int speedLimit;
    private int roadType;
    @Nullable
    private boolean ignition;

    @Override
    public String toString() {
        return "Packet{" +
                "id=" + id +
                ", vehicleId='" + vehicleId + '\'' +
                ", location=" + location +
                ", dateTime=" + dateTime +
                ", speed=" + speed +
                ", speedLimit=" + speedLimit +
                ", roadType=" + roadType +
                ", ignition=" + ignition +
                '}';
    }
}
