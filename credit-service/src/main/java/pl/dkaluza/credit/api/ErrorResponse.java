package pl.dkaluza.credit.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.ZonedDateTime;

@Builder
@Data
public class ErrorResponse {
    @JsonSerialize(using = HttpStatusSerializer.class, as = HttpStatus.class)
    private final HttpStatus status;

    @Builder.Default
    private final ZonedDateTime timestamp = ZonedDateTime.now();

    private final String message;

    @JsonIgnore
    private final HttpHeaders headers;

    public ResponseEntity<Object> toResponseEntity() {
        return new ResponseEntity<>(this, status);
    }

    private static class HttpStatusSerializer extends JsonSerializer<HttpStatus> {
        @Override
        public void serialize(HttpStatus status, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(status.value());
        }
    }
}
