package pl.dkaluza.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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

    @Column(length = 64)
    private String firstName;

    @Column(length = 64)
    private String surname;

    @Column(length = 11)
    private String pesel;
}
