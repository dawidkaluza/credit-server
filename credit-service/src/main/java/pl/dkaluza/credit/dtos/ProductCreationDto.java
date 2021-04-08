package pl.dkaluza.credit.dtos;

public class ProductCreationDto {
    private Long creditId;

    private String name;

    private Integer value;

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
    public String toString() {
        return "ProductCreationDto{" +
            "creditId=" + creditId +
            ", name='" + name + '\'' +
            ", value=" + value +
            '}';
    }
}
