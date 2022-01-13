package fontys.crossyn.controller;

import fontys.crossyn.dto.UserDTO;
import fontys.crossyn.service.RefreshToken;
import fontys.crossyn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity createAccount(@RequestBody UserDTO userDTO){
        try{
            userService.createUser(userDTO);
            return ResponseEntity.ok().build();
        }
        catch(RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshToken(@RequestHeader(name = "refresh_token")String token) throws IOException {
        System.out.println(token);
        RefreshToken refreshToken = new RefreshToken(userService);
        HttpHeaders headers = refreshToken.getNewToken(token);
        return ResponseEntity.ok().headers(headers).build();
    }


}
