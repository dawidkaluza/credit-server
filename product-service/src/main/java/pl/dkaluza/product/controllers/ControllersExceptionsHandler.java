package pl.dkaluza.product.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.dkaluza.product.exceptions.ProductNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ControllersExceptionsHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public void productNotFoundExcHandler(HttpServletResponse response, ProductNotFoundException e) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
