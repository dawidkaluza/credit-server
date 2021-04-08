package pl.dkaluza.credit.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionsHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return ErrorResponse.builder()
            .status(HttpStatus.UNPROCESSABLE_ENTITY)
            .message(e.getMessage())
            .build()
            .toResponseEntity();
    }

}
