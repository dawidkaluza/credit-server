package pl.dkaluza.credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dkaluza.credit.aggregators.CreditInformationAggregator;
import pl.dkaluza.credit.dtos.*;
import pl.dkaluza.credit.entities.Credit;
import pl.dkaluza.credit.mappers.CreditDtoMapper;
import pl.dkaluza.credit.mappers.CustomerCreationMapper;
import pl.dkaluza.credit.mappers.ProductCreationMapper;
import pl.dkaluza.credit.repositories.CreditRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditInformationAggregator creditInfoAggregator;
    private final CreditDtoMapper creditDtoMapper;
    private final CustomerCreationMapper customerCreationMapper;
    private final ProductCreationMapper productCreationMapper;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public CreditService(CreditRepository creditRepository, CreditInformationAggregator creditInfoAggregator, CreditDtoMapper creditDtoMapper, CustomerCreationMapper customerCreationMapper, ProductCreationMapper productCreationMapper, CustomerService customerService, ProductService productService) {
        this.creditRepository = creditRepository;
        this.creditInfoAggregator = creditInfoAggregator;
        this.creditDtoMapper = creditDtoMapper;
        this.customerCreationMapper = customerCreationMapper;
        this.productCreationMapper = productCreationMapper;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Transactional(readOnly = true)
    public List<CreditInformationDto> getCredits() {
        List<Credit> credits = creditRepository.findAll();
        // Used to increase performance
        if (credits.isEmpty()) {
            return Collections.emptyList();
        }

        List<CreditDto> creditDtos = credits
            .stream()
            .map(creditDtoMapper::toObject)
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
    public CreditIdDto createCredit(CreditInformationDto creditInfo) {
        CreditDto creditDto = creditInfo.getCredit();
        Credit credit = new Credit();
        credit.setCreditName(creditDto.getCreditName());
        credit = creditRepository.save(credit);
        Long creditId = credit.getId();

        CustomerCreationDto customerCreation = customerCreationMapper.toObject(Pair.of(creditInfo.getCustomer(), creditId));
        customerService.createCustomer(customerCreation);

        ProductCreationDto productCreation = productCreationMapper.toObject(Pair.of(creditInfo.getProduct(), creditId));
        productService.createProduct(productCreation);

        return new CreditIdDto(creditId);
    }
}
