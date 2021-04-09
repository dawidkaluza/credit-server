package pl.dkaluza.customer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dkaluza.customer.entities.Customer;
import pl.dkaluza.customer.exceptions.CustomerNotFoundException;
import pl.dkaluza.customer.services.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getCustomers(@RequestParam("creditIds") List<Long> creditIds) throws CustomerNotFoundException {
        return customerService.getAllCustomersByCreditIds(creditIds);
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }
}
