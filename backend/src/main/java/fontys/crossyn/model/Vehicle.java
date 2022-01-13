package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id @GeneratedValue private long id;
    //add List of Trip object here...
    private int userId;
    private int fleetId;

}