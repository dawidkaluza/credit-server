package pl.dkaluza.credit.dtos;

public class CreditDto {
    private String creditName;

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @Override
    public String toString() {
        return "CreditDto{" +
            "creditName='" + creditName + '\'' +
            '}';
    }
}
