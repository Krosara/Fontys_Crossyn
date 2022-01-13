package fontys.crossyn.service;

import fontys.crossyn.dto.UserDTO;
import fontys.crossyn.model.User;
import fontys.crossyn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User readByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public void createUser(UserDTO userDTO){
        User newAccount = new User();
        Optional<User> byUsername = userRepository.findByUsername(userDTO.getUsername());
        if(byUsername.isPresent()){
            throw new RuntimeException("User already registered! Please use different username");
        }
        newAccount.setUsername(userDTO.getUsername());
        newAccount.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newAccount.setEmail(userDTO.getEmail());
        userRepository.save(newAccount);
    }
}
