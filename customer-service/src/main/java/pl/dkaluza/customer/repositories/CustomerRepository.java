package pl.dkaluza.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dkaluza.customer.entities.Customer;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByCreditIdIn(Collection<Long> creditIds);
}
