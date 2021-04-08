package pl.dkaluza.credit.mappers;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pl.dkaluza.credit.dtos.CustomerCreationDto;
import pl.dkaluza.credit.dtos.CustomerDto;

@Component
public class CustomerCreationMapper implements Mapper<Pair<CustomerDto, Long>, CustomerCreationDto> {
    @Override
    public CustomerCreationDto toObject(Pair<CustomerDto, Long> pair) {
        CustomerCreationDto customerCreation = new CustomerCreationDto();
        customerCreation.setCreditId(pair.getSecond());
        CustomerDto customer = pair.getFirst();
        customerCreation.setFirstName(customer.getFirstName());
        customerCreation.setSurname(customer.getSurname());
        customerCreation.setPesel(customer.getPesel());
        return customerCreation;
    }
}
