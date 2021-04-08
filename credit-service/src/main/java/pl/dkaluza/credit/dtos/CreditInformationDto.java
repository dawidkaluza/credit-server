package pl.dkaluza.credit.dtos;

public class CreditInformationDto {
    private final CreditDto credit;

    private final CustomerDto customer;

    private final ProductDto product;

    public CreditInformationDto(CreditDto credit, CustomerDto customer, ProductDto product) {
        this.credit = credit;
        this.customer = customer;
        this.product = product;
    }

    public CreditDto getCredit() {
        return credit;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public ProductDto getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "CreditInformationDto{" +
            "credit=" + credit +
            ", customer=" + customer +
            ", product=" + product +
            '}';
    }
}
