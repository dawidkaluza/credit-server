package pl.dkaluza.customer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;
import pl.dkaluza.customer.entities.Customer;
import pl.dkaluza.customer.repositories.CustomerRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseContractClass {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void before(WebApplicationContext webAppContext) {
        customerRepository.save(new Customer(1L, "David", "Davidovsky", "11223344556"));
        customerRepository.save(new Customer(2L, "Mark", "Markiee", "11223344556"));
        RestAssuredMockMvc.webAppContextSetup(webAppContext);
    }
}
