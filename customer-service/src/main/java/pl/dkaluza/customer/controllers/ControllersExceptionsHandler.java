package pl.dkaluza.customer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.dkaluza.customer.exceptions.CustomerNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ControllersExceptionsHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public void customerNotFoundExcHandler(HttpServletResponse response, CustomerNotFoundException e) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
