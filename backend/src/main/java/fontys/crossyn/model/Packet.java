package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Packet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vehicleId;
    @Embedded
    private Location location;
    private String dateTime;
    private String speed;
    private String speedLimit;
    private String roadType;
    @Nullable
    private boolean ignition;

}
