package pl.dkaluza.credit.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dkaluza.credit.dtos.basic.CreditDto;
import pl.dkaluza.credit.dtos.basic.CustomerDto;
import pl.dkaluza.credit.dtos.basic.ProductDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CreditCreationDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        @NotNull
        @Valid
        private CreditDto credit;

        @NotNull
        @Valid
        private CustomerDto customer;

        @NotNull
        @Valid
        private ProductDto product;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long creditId;
    }
}
