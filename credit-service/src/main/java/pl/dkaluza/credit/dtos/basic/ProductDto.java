package pl.dkaluza.credit.dtos.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotBlank
    @Size(min = 3, max = 64)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "First name must contain only letters, numbers and spaces")
    private String name;

    @NotNull
    @Positive
    private Integer value;
}
