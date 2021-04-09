package pl.dkaluza.customer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.dkaluza.customer.exceptions.CustomerNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ControllersExceptionsHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> customerNotFoundExcHandler() {
        return ApiError.builder()
            .status(HttpStatus.NOT_FOUND)
            .message("Can't find some customers")
            .build().toResponseEntity();
    }
}
