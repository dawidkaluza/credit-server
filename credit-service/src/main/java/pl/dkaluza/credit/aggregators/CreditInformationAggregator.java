package pl.dkaluza.credit.aggregators;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import pl.dkaluza.credit.dtos.CreditDto;
import pl.dkaluza.credit.dtos.CreditInformationDto;
import pl.dkaluza.credit.dtos.CustomerDto;
import pl.dkaluza.credit.dtos.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditInformationAggregator {
    public List<CreditInformationDto> aggregate(List<CreditDto> credits, List<CustomerDto> customers, List<ProductDto> products) {
        int creditsSize = credits.size();
        Assert.isTrue(creditsSize == customers.size(), "List of customers has different size than list of credits");
        Assert.isTrue(creditsSize == products.size(), "List of products has different size than list of credits");

        List<CreditInformationDto> result = new ArrayList<>();
        for (int i = 0; i < creditsSize; i++) {
            result.add(
                new CreditInformationDto(credits.get(i), customers.get(i), products.get(i))
            );
        }
        return result;
    }
}
