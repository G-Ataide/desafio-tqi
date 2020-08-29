package br.com.core.repository;

import br.com.core.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("SELECT s FROM #{#entityName} s WHERE s.email like ?1 ")
    Optional<Client> findByEmail(String email);

    @Query("SELECT s FROM #{#entityName} s WHERE s.email like ?1 and s.password = ?2")
    Optional<Client> findOneByEmailAndPassword(String email, String password);

}
