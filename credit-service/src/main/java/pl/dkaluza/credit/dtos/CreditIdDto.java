package pl.dkaluza.credit.dtos;

public class CreditIdDto {
    private Long creditId;

    public CreditIdDto() {
    }

    public CreditIdDto(Long creditId) {
        this.creditId = creditId;
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    @Override
    public String toString() {
        return "CreditIdDto{" +
            "creditId=" + creditId +
            '}';
    }
}
