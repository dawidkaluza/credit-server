package pl.dkaluza.credit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dkaluza.credit.dtos.CreditCreationDto;
import pl.dkaluza.credit.dtos.CreditInformationDto;
import pl.dkaluza.credit.services.CreditService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @GetMapping("/credit")
    public List<CreditInformationDto.Response> getCredits() {
        return creditService.getCredits();
    }

    @PostMapping("/credit")
    public CreditCreationDto.Response createCredit(@RequestBody @Valid CreditCreationDto.Request creditCreation) {
        return creditService.createCredit(creditCreation);
    }
}
