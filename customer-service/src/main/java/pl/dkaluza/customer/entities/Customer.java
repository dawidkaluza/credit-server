package pl.dkaluza.customer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private Long creditId;

    private String firstName;

    private String surname;

    private String pesel;

    public Customer() {
    }

    public Customer(Long creditId, String firstName, String surname, String pesel) {
        this.creditId = creditId;
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;
        return creditId.equals(customer.creditId);
    }

    @Override
    public int hashCode() {
        return creditId.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + creditId +
            '}';
    }
}
