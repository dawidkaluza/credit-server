package pl.dkaluza.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dkaluza.customer.entities.Customer;
import pl.dkaluza.customer.exceptions.CustomerNotFoundException;
import pl.dkaluza.customer.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

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
            orderedCustomers.add(
                customers
                    .stream()
                    .filter(customer -> customer.getCreditId().equals(creditIds.get(finalI)))
                    .findAny()
                    .orElseThrow(() -> new CustomerNotFoundException("No customer with id=" + finalI))
            );
        }
        return orderedCustomers;
    }
}
