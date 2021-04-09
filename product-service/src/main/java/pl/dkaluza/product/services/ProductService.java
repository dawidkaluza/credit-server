package pl.dkaluza.product.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dkaluza.product.entities.Product;
import pl.dkaluza.product.exceptions.ProductNotFoundException;
import pl.dkaluza.product.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProductsByCreditIds(List<Long> creditIds) {
        List<Product> products = productRepository.findAllByCreditIdIn(creditIds);

        // By this approach we're sure that duplicated ids will also be repeated in the results' list
        List<Product> orderedProducts = new ArrayList<>();
        int len = creditIds.size();
        for (int i = 0; i < len; i++) {
            int finalI = i;
            Product product = products
                .stream()
                .filter(otherProduct -> otherProduct.getCreditId().equals(creditIds.get(finalI)))
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("No product with id=" + finalI));

            orderedProducts.add(product);
            products.remove(product);
        }

        return orderedProducts;
    }
}
