package pl.dkaluza.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
