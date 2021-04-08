package pl.dkaluza.product;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import pl.dkaluza.product.controllers.ProductController;
import pl.dkaluza.product.entities.Product;
import pl.dkaluza.product.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class BaseContractClass {

    @BeforeEach
    public void before() {
        List<Long> creditIds = new ArrayList<>();
        creditIds.add(1L);
        creditIds.add(2L);

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "TV", 100));
        products.add(new Product(2L, "Car", 1000));

        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.getAllProductsByCreditIds(creditIds)).thenReturn(products);
        RestAssuredMockMvc.standaloneSetup(new ProductController(productService));
    }
}
