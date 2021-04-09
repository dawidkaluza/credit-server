package pl.dkaluza.product;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;
import pl.dkaluza.product.entities.Product;
import pl.dkaluza.product.repositories.ProductRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseContractClass {
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void before(WebApplicationContext webAppContext) {
        productRepository.save(new Product(1L, "TV", 100));
        productRepository.save(new Product(2L, "Car", 1000));
        RestAssuredMockMvc.webAppContextSetup(webAppContext);
    }
}
