package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    private double lat;
    private double lon;
    private int alt;

}
