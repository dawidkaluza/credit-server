package pl.dkaluza.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = "creditId")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private Long creditId;

    private String firstName;

    private String surname;

    private String pesel;
}
