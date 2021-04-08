package pl.dkaluza.credit.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.dkaluza.credit.dtos.ProductCreationDto;
import pl.dkaluza.credit.dtos.basic.ProductDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final RestTemplate restTemplate;
    private @Value("${product.origin:http://localhost:8080/}") String productServiceOrigin;

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

    public void createProduct(ProductCreationDto.Request product) {
        restTemplate.postForObject(productServiceOrigin + "/product", product, ProductCreationDto.Request.class);
    }
}
