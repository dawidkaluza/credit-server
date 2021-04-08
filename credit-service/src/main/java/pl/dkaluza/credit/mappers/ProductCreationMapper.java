package pl.dkaluza.credit.mappers;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pl.dkaluza.credit.dtos.ProductCreationDto;
import pl.dkaluza.credit.dtos.ProductDto;

@Component
public class ProductCreationMapper implements Mapper<Pair<ProductDto, Long>, ProductCreationDto> {
    @Override
    public ProductCreationDto toObject(Pair<ProductDto, Long> pair) {
        ProductCreationDto productCreation = new ProductCreationDto();
        productCreation.setCreditId(pair.getSecond());
        ProductDto product = pair.getFirst();
        productCreation.setName(product.getName());
        productCreation.setValue(product.getValue());
        return productCreation;
    }
}
