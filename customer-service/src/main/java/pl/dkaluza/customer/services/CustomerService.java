package pl.dkaluza.customer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dkaluza.customer.entities.Customer;
import pl.dkaluza.customer.exceptions.CustomerNotFoundException;
import pl.dkaluza.customer.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomersByCreditIds(List<Long> creditIds) throws CustomerNotFoundException {
        List<Customer> customers = customerRepository.findAllByCreditIdIn(creditIds);

        // By this approach we're sure that duplicated ids will also be repeated in the results' list
        List<Customer> orderedCustomers = new ArrayList<>();
        int len = creditIds.size();
        for (int i = 0; i < len; i++) {
            int finalI = i;
            Customer customer = customers
                .stream()
                .filter(otherCustomer -> otherCustomer.getCreditId().equals(creditIds.get(finalI)))
                .findAny()
                .orElseThrow(() -> new CustomerNotFoundException("No customer with id=" + finalI));

            orderedCustomers.add(customer);
            customers.remove(customer);
        }
        return orderedCustomers;
    }
}
