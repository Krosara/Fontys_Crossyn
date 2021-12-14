package fontys.crossyn.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


public class ApiException {

    @Getter
    private final String message;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final ZonedDateTime timeStamp;


    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
}
