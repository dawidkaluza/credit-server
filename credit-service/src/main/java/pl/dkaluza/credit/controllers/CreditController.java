package pl.dkaluza.credit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dkaluza.credit.dtos.CreditIdDto;
import pl.dkaluza.credit.dtos.CreditInformationDto;
import pl.dkaluza.credit.services.CreditService;

import java.util.List;

@RestController
public class CreditController {
    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/credit")
    public List<CreditInformationDto> getCredits() {
        return creditService.getCredits();
    }

    @PostMapping("/credit")
    public CreditIdDto createCredit(@RequestBody CreditInformationDto creditInfo) {
        return creditService.createCredit(creditInfo);
    }
}
