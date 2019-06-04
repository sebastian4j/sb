package cl.sebastian.uno.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import cl.sebastian.uno.dominio.Author;

@EnableTransactionManagement
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
