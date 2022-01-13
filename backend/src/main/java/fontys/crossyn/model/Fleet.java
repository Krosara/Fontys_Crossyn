package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fleet {

    @Id @GeneratedValue private long id;
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private User user;
    private String name;
    private String userId = user.getId();

}
