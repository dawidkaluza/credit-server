package pl.dkaluza.product.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    private Long creditId;

    private String name;

    private Integer value;

    public Product() {
    }

    public Product(Long creditId, String name, Integer value) {
        this.creditId = creditId;
        this.name = name;
        this.value = value;
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;
        return creditId.equals(product.creditId);
    }

    @Override
    public int hashCode() {
        return creditId.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + creditId +
            '}';
    }
}
