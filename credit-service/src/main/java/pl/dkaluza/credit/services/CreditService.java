package pl.dkaluza.credit.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dkaluza.credit.aggregators.CreditInformationAggregator;
import pl.dkaluza.credit.dtos.CreditCreationDto;
import pl.dkaluza.credit.dtos.CreditInformationDto;
import pl.dkaluza.credit.dtos.CustomerCreationDto;
import pl.dkaluza.credit.dtos.ProductCreationDto;
import pl.dkaluza.credit.dtos.basic.CreditDto;
import pl.dkaluza.credit.dtos.basic.CustomerDto;
import pl.dkaluza.credit.dtos.basic.ProductDto;
import pl.dkaluza.credit.entities.Credit;
import pl.dkaluza.credit.repositories.CreditRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditInformationAggregator creditInfoAggregator;
    private final CreditDto.Mapper creditDtoMapper;
    private final CustomerCreationDto.Request.CustomerWithIdMapper customerCreationMapper;
    private final ProductCreationDto.Request.ProductWithIdMapper productCreationMapper;
    private final CustomerService customerService;
    private final ProductService productService;

    @Transactional(readOnly = true)
    public List<CreditInformationDto.Response> getCredits() {
        List<Credit> credits = creditRepository.findAll();
        // Used to increase performance
        if (credits.isEmpty()) {
            return Collections.emptyList();
        }

        List<CreditDto> creditDtos = credits
            .stream()
            .map(creditDtoMapper::toDto)
            .collect(Collectors.toList());

        List<Long> creditIds = credits
            .stream()
            .map(Credit::getId)
            .collect(Collectors.toList());

        List<CustomerDto> customers = customerService.getCustomersByIds(creditIds);
        List<ProductDto> products = productService.getProductsByIds(creditIds);
        return creditInfoAggregator.aggregate(creditDtos, customers, products);
    }

    @Transactional
    public CreditCreationDto.Response createCredit(CreditCreationDto.Request creditCreation) {
        Credit credit = creditDtoMapper.toEntity(creditCreation.getCredit());
        credit = creditRepository.save(credit);
        Long creditId = credit.getId();

        CustomerCreationDto.Request customerCreation = customerCreationMapper.toDto(Pair.of(creditCreation.getCustomer(), creditId));
        customerService.createCustomer(customerCreation);

        ProductCreationDto.Request productCreation = productCreationMapper.toDto(Pair.of(creditCreation.getProduct(), creditId));
        productService.createProduct(productCreation);

        return new CreditCreationDto.Response(creditId);
    }
}
