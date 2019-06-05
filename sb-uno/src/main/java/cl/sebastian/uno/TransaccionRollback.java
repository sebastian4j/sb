package cl.sebastian.uno;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cl.sebastian.uno.dominio.Author;
import cl.sebastian.uno.dominio.Book;
import cl.sebastian.uno.dominio.Publisher;
import cl.sebastian.uno.repositories.AuthorRepository;
import cl.sebastian.uno.repositories.BookRepository;
import cl.sebastian.uno.repositories.PublisherRepository;

@Component
@EnableTransactionManagement
public class TransaccionRollback {
  private final AuthorRepository ar;
  private final BookRepository br;
  private final PublisherRepository cr;

  public TransaccionRollback(final AuthorRepository ar, final BookRepository br, final PublisherRepository cr) {
    this.ar = ar;
    this.br = br;
    this.cr = cr;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void trx() {
    final var p1 = new Publisher("name-px", "add-px");
    cr.save(p1);
    final var a1 = new Author("sebastianx", "avilax");
    final var b1 = new Book("titulo-1x", "isbn-1x", p1);
    a1.getBooks().add(b1);
    ar.save(a1);
    b1.getAuthors().add(a1);
    br.save(b1);
    final var a2 = new Author("eliasx", "montecinosx");
    final var b2 = new Book("titulo-2x", "isbn-2x", p1);
    if (a2 != null) { // generará el rollback
      throw new IllegalStateException("forzado");
    }
    a2.getBooks().add(b2);
    ar.save(a2);
    b2.getAuthors().add(a2);
    br.save(b2);
  }
}
