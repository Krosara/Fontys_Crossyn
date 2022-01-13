package fontys.crossyn.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import fontys.crossyn.config.AuthenticationConfiguration;
import fontys.crossyn.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class RefreshToken {
    private final UserService userService;

    public RefreshToken(UserService userService) {this.userService = userService;}

    public HttpHeaders getNewToken(String refreshToken){
        System.out.println("1");
        if(refreshToken == null || !refreshToken.startsWith(AuthenticationConfiguration.TOKEN_PREFIX)){
            throw new RuntimeException("Refresh token missing");
        }
        User user = decodeJWT(refreshToken);
        if(user != null){
            HttpHeaders headers = new HttpHeaders();
            headers.add("auth_token", generateToken(user));
            headers.add("refresh_token", refreshToken);
            return headers;
        }
        return null;
    }

    private User decodeJWT(String token){
        if(token != null){
            DecodedJWT verify = JWT.require(Algorithm.HMAC512(AuthenticationConfiguration.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(AuthenticationConfiguration.TOKEN_PREFIX, ""));
            String username = verify.getSubject();
            if(username != null){
                return userService.readByUsername(username);
            }
            return null;
        }
        return null;
    }

    private String generateToken(User acc){
        return JWT.create()
                .withSubject(acc.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConfiguration.EXPIRATION_TIME))
                .withClaim("role", getAuthorities(acc.getRole()).iterator().next().getAuthority())
                .sign(Algorithm.HMAC512(AuthenticationConfiguration.SECRET.getBytes()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
