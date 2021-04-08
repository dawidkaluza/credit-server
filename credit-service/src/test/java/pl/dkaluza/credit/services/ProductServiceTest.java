package pl.dkaluza.credit.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.dkaluza.credit.dtos.ProductCreationDto;
import pl.dkaluza.credit.dtos.ProductDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "pl.dkaluza:product:+:stubs:8080"
)
public class ProductServiceTest {
    private final ProductService productService;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void getProductsByIds_existingIds_returnProducts() {
        // Given
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

        // When
        List<ProductDto> products = productService.getProductsByIds(ids);

        // Then
        assertEquals(products.size(), 2);
        assertEquals(products.get(0).getName(), "TV");
        assertEquals(products.get(0).getValue(), 100);
        assertEquals(products.get(1).getName(), "Car");
        assertEquals(products.get(1).getValue(), 1000);
    }

    @Test
    public void createProduct_validCreationObject_noException() {
        // Given
        ProductCreationDto productCreation = new ProductCreationDto();
        productCreation.setCreditId(3L);
        productCreation.setName("Computer");
        productCreation.setValue(500);

        // When, then
        productService.createProduct(productCreation);
    }
}
