package pl.dkaluza.credit.dtos.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    @NotBlank
    @Size(min = 3, max = 64)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 64)
    private String surname;

    @NotBlank
    @Pattern(regexp = "^\\d{11}$", message = "Pesel must contain 11 digits")
    private String pesel;
}
