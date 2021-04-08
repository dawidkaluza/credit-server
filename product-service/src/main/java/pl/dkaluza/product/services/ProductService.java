package pl.dkaluza.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dkaluza.product.entities.Product;
import pl.dkaluza.product.exceptions.ProductNotFoundException;
import pl.dkaluza.product.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
            orderedProducts.add(
                products
                    .stream()
                    .filter(product -> product.getCreditId().equals(creditIds.get(finalI)))
                    .findAny()
                    .orElseThrow(() -> new ProductNotFoundException("No product with id=" + finalI))
            );
        }

        return orderedProducts;
    }
}