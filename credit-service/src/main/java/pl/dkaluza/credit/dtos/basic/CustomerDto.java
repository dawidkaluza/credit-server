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
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "First name must contain only letters, numbers and spaces")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 64)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Surname must contain only letters, numbers and spaces")
    private String surname;

    @NotBlank
    @Pattern(regexp = "^\\d{11}$", message = "Pesel must contain 11 digits")
    private String pesel;
}
