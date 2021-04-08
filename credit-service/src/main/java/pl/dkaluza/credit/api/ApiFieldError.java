package pl.dkaluza.credit.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiFieldError {
    private final String field;

    private final String message;
}
