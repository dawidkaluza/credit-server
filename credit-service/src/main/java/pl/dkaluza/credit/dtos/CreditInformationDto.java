package pl.dkaluza.credit.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dkaluza.credit.dtos.basic.CreditDto;
import pl.dkaluza.credit.dtos.basic.CustomerDto;
import pl.dkaluza.credit.dtos.basic.ProductDto;

public class CreditInformationDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private CreditDto credit;

        private CustomerDto customer;

        private ProductDto product;
    }
}
