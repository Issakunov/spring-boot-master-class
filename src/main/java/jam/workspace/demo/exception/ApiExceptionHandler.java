package jam.workspace.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException) {

        ApiException apiException = new ApiException(apiRequestException.getMessage(),apiRequestException, BAD_REQUEST, ZonedDateTime.now());

        return new ResponseEntity<>(apiException, BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(NotFoundException notFoundException) {

        ApiException apiException = new ApiException(notFoundException.getMessage(),notFoundException, NOT_FOUND, ZonedDateTime.now());

        return new ResponseEntity<>(apiException, NOT_FOUND);
    }
}
