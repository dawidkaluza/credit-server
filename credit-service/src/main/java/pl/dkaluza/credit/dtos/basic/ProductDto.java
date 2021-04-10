package pl.dkaluza.credit.dtos.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotBlank
    @Size(min = 3, max = 64)
    private String name;

    @NotNull
    @Positive
    private Integer value;
}
