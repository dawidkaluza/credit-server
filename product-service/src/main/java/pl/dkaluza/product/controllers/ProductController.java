package pl.dkaluza.product.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dkaluza.product.entities.Product;
import pl.dkaluza.product.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public List<Product> getProducts(@RequestParam("creditIds") List<Long> creditIds) {
        return productService.getAllProductsByCreditIds(creditIds);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}

