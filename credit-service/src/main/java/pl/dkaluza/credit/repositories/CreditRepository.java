package pl.dkaluza.credit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dkaluza.credit.entities.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
}
