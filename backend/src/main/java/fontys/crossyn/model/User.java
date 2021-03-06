package fontys.crossyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

    @Id @GeneratedValue private String id;
    private String username;
    private String password;
    private String fullName;
    private String email;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


}
