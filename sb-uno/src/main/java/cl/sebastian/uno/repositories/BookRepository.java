package cl.sebastian.uno.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import cl.sebastian.uno.dominio.Book;

@EnableTransactionManagement
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

}
