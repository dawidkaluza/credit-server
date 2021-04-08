package pl.dkaluza.credit.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pl.dkaluza.credit.dtos.basic.CustomerDto;

public class CustomerCreationDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long creditId;

        private String firstName;

        private String surname;

        private String pesel;

        @Component
        public static class CustomerWithIdMapper implements DtoMapper<Pair<CustomerDto, Long>, Request> {
            @Override
            public Request toDto(Pair<CustomerDto, Long> pair) {
                Request request = new Request();
                request.setCreditId(pair.getSecond());

                CustomerDto customer = pair.getFirst();
                request.setFirstName(customer.getFirstName());
                request.setSurname(customer.getSurname());
                request.setPesel(customer.getPesel());
                return request;
            }
        }
    }
}
