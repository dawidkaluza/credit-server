package pl.dkaluza.product.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(of = "creditId")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long creditId;

    @Column(length = 64)
    private String name;

    private Integer value;
}
