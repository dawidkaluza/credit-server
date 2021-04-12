package pl.dkaluza.credit.dtos.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dkaluza.credit.dtos.DtoMapper;
import pl.dkaluza.credit.dtos.EntityMapper;
import pl.dkaluza.credit.entities.Credit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditDto {
    @NotBlank
    @Size(min = 3, max = 64)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Name must contain only letters, numbers and spaces")
    private String name;

    @Component
    public static class Mapper implements DtoMapper<Credit, CreditDto>, EntityMapper<CreditDto, Credit> {
        @Override
        public CreditDto toDto(Credit credit) {
            return new CreditDto(credit.getName());
        }

        @Override
        public Credit toEntity(CreditDto object) {
            Credit credit = new Credit();
            credit.setName(object.getName());
            return credit;
        }
    }
}
