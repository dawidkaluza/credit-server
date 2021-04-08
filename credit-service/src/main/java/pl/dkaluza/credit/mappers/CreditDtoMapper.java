package pl.dkaluza.credit.mappers;

import org.springframework.stereotype.Component;
import pl.dkaluza.credit.dtos.CreditDto;
import pl.dkaluza.credit.entities.Credit;

@Component
public class CreditDtoMapper implements Mapper<Credit, CreditDto> {
    @Override
    public CreditDto toObject(Credit credit) {
        CreditDto creditDto = new CreditDto();
        creditDto.setCreditName(credit.getCreditName());
        return creditDto;
    }
}
