package pl.dkaluza.customer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import pl.dkaluza.customer.controllers.CustomerController;
import pl.dkaluza.customer.entities.Customer;
import pl.dkaluza.customer.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class BaseContractClass {

    @BeforeEach
    public void before() {
        List<Long> creditIds = new ArrayList<>();
        creditIds.add(1L);
        creditIds.add(2L);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "David", "Davidovsky", "11223344556"));
        customers.add(new Customer(2L, "Mark", "Markiee", "11223344556"));

        CustomerService customerService = Mockito.mock(CustomerService.class);
        Mockito.when(customerService.getAllCustomersByCreditIds(creditIds)).thenReturn(customers);
        RestAssuredMockMvc.standaloneSetup(new CustomerController(customerService));
    }
}
