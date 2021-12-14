package fontys.crossyn.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import fontys.crossyn.config.AuthenticationConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
           fontys.crossyn.model.User credentials = new ObjectMapper().readValue(request.getInputStream(), fontys.crossyn.model.User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConfiguration.EXPIRATION_TIME))
                //.withClaim("role", auth.getAuthorities().iterator().next().getAuthority())
                .sign(Algorithm.HMAC512(AuthenticationConfiguration.SECRET.getBytes()));
        response.addHeader(AuthenticationConfiguration.HEADER_STRING, AuthenticationConfiguration.TOKEN_PREFIX + token);

        String refreshToken = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConfiguration.REFRESH_EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(AuthenticationConfiguration.SECRET.getBytes()));
        response.addHeader(AuthenticationConfiguration.REFRESH_HEADER_STRING, AuthenticationConfiguration.TOKEN_PREFIX + refreshToken);
    }

}
