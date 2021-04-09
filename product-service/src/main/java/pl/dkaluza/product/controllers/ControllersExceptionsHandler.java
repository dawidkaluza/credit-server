package pl.dkaluza.product.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.dkaluza.product.exceptions.ProductNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ControllersExceptionsHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> productNotFoundExcHandler() {
        return ApiError.builder()
            .status(HttpStatus.NOT_FOUND)
            .message("Can't find some products")
            .build().toResponseEntity();
    }
}
