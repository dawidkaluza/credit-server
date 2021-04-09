package pl.dkaluza.credit.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientException;
import pl.dkaluza.credit.dtos.CustomerCreationDto;
import pl.dkaluza.credit.dtos.basic.CustomerDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "pl.dkaluza:customer:+:stubs:8080"
)
public class CustomerServiceTest {
    private final CustomerService customerService;

    @Autowired
    public CustomerServiceTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void getCustomersByIds_existingIds_returnCustomers() {
        // Given
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

        // When
        List<CustomerDto> customers = customerService.getCustomersByIds(ids);

        //Then
        assertEquals(customers.size(), 2);

        CustomerDto firstCustomer = customers.get(0);
        assertEquals(firstCustomer.getFirstName(), "David");
        assertEquals(firstCustomer.getSurname(), "Davidovsky");
        assertEquals(firstCustomer.getPesel(), "11223344556");

        CustomerDto secondCustomer = customers.get(1);
        assertEquals(secondCustomer.getFirstName(), "Mark");
        assertEquals(secondCustomer.getSurname(), "Markiee");
        assertEquals(secondCustomer.getPesel(), "11223344556");
    }

    @Test
    public void getCustomersByIds_notExistingIds_throwException() {
        // Given
        List<Long> ids = new ArrayList<>();
        ids.add(3L);

        // When, then
        assertThrows(RestClientException.class, () -> customerService.getCustomersByIds(ids));
    }

    @Test
    public void createCustomer_validCreationObject_noException() {
        // Given
        CustomerCreationDto.Request customerCreation = new CustomerCreationDto.Request();
        customerCreation.setCreditId(3L);
        customerCreation.setFirstName("Alfa");
        customerCreation.setSurname("Romeo");
        customerCreation.setPesel("11335577990");

        // When, then
        customerService.createCustomer(customerCreation);
    }
}
