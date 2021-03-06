package fontys.crossyn.dto;

import fontys.crossyn.model.Packet;
import lombok.Data;
import lombok.Getter;

import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class TripDTO {
    private String _id;
    private String vehicleID;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private List<Packet> packets;
    private int averageSpeed;
    private int topSpeed;
}
