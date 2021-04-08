package pl.dkaluza.credit.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pl.dkaluza.credit.dtos.basic.ProductDto;

public class ProductCreationDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long creditId;

        private String name;

        private Integer value;

        @Component
        public static class ProductWithIdMapper implements DtoMapper<Pair<ProductDto, Long>, Request> {
            @Override
            public Request toDto(Pair<ProductDto, Long> pair) {
                Request productCreation = new Request();
                productCreation.setCreditId(pair.getSecond());

                ProductDto product = pair.getFirst();
                productCreation.setName(product.getName());
                productCreation.setValue(product.getValue());
                return productCreation;
            }
        }
    }
}
