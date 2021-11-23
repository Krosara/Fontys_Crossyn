package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Location {

    private double lat;
    private double lon;
    private int alt;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location)o;
        return (lat == location.getLat() && lon == location.getLon() && alt == location.getAlt());
    }

}


