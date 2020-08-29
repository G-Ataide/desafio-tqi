package br.com.core.repository;

import br.com.core.model.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long> {
    @Query("SELECT s FROM #{#entityName} s WHERE s.client_id = ?1")
    List<Loan> findAllByClientId(Long clientId);
}
