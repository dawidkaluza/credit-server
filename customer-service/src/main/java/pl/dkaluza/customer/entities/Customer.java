package pl.dkaluza.customer.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = "creditId")
public class Customer {
    @Id
    private Long creditId;

    private String firstName;

    private String surname;

    private String pesel;
}
