package pl.dkaluza.credit.dtos;

public class CustomerDto {
    private String firstName;

    private String surname;

    private String pesel;

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
    public String toString() {
        return "CustomerDto{" +
            "firstName='" + firstName + '\'' +
            ", surname='" + surname + '\'' +
            ", pesel='" + pesel + '\'' +
            '}';
    }
}
