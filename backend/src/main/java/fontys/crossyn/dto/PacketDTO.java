package fontys.crossyn.dto;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Location;
import lombok.Data;

import javax.persistence.Embedded;
import java.time.ZonedDateTime;

@Data
public class PacketDTO {
    private String id;
    private String vehicleId;
    @Embedded
    private Location location;
    private ZonedDateTime date;
    private int speed;
    private int speedLimit;
    private int roadType;
    private IgnitionStates ignition;
}
