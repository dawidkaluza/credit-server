package pl.dkaluza.credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.dkaluza.credit.dtos.ProductCreationDto;
import pl.dkaluza.credit.dtos.ProductDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private final RestTemplate restTemplate;
    private final String productServiceOrigin;

    @Autowired
    public ProductService(RestTemplate restTemplate, @Value("${product.origin:http://localhost:8080/}") String productServiceOrigin) {
        this.restTemplate = restTemplate;
        this.productServiceOrigin = productServiceOrigin;
    }

    public List<ProductDto> getProductsByIds(List<Long> creditIds) {
        UriComponentsBuilder customerUriBuilder = UriComponentsBuilder
            .fromHttpUrl(productServiceOrigin + "/product")
            .queryParam("creditIds", creditIds);

        ProductDto[] products = restTemplate.getForObject(customerUriBuilder.toUriString(), ProductDto[].class);
        if (products == null) {
            return Collections.emptyList();
        }

        return Arrays.asList(products);
    }

    public void createProduct(ProductCreationDto product) {
        restTemplate.postForObject(productServiceOrigin + "/product", product, ProductDto.class);
    }
}
