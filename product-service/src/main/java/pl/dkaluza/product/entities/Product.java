package pl.dkaluza.product.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(of = "creditId")
public class Product {
    @Id
    private Long creditId;

    private String name;

    private Integer value;
}
