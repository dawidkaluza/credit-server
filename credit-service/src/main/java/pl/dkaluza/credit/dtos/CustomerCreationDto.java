package pl.dkaluza.credit.dtos;

public class CustomerCreationDto {
    private Long creditId;

    private String firstName;

    private String surname;

    private String pesel;

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
    public String toString() {
        return "CustomerCreationDto{" +
            "creditId=" + creditId +
            ", firstName='" + firstName + '\'' +
            ", surname='" + surname + '\'' +
            ", pesel='" + pesel + '\'' +
            '}';
    }
}
