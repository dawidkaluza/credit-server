package pl.dkaluza.credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.dkaluza.credit.dtos.CustomerCreationDto;
import pl.dkaluza.credit.dtos.CustomerDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    private final RestTemplate restTemplate;
    private final String customerServiceOrigin;

    @Autowired
    public CustomerService(RestTemplate restTemplate, @Value("${customer.origin:http://localhost:8080/}") String customerServiceOrigin) {
        this.restTemplate = restTemplate;
        this.customerServiceOrigin = customerServiceOrigin;
    }

    public List<CustomerDto> getCustomersByIds(List<Long> creditIds) {
        UriComponentsBuilder customerUriBuilder = UriComponentsBuilder
            .fromHttpUrl(customerServiceOrigin + "/customer")
            .queryParam("creditIds", creditIds);

        CustomerDto[] customers = restTemplate.getForObject(customerUriBuilder.toUriString(), CustomerDto[].class);
        if (customers == null) {
            return Collections.emptyList();
        }

        return Arrays.asList(customers);
    }

    public void createCustomer(CustomerCreationDto customer) {
        restTemplate.postForObject(customerServiceOrigin + "/customer", customer, CustomerCreationDto.class);
    }
}
