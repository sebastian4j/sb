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
public class TransaccionNoRollback {
  private final AuthorRepository ar;
  private final BookRepository br;
  private final PublisherRepository cr;

  public TransaccionNoRollback(final AuthorRepository ar, final BookRepository br, final PublisherRepository cr) {
    this.ar = ar;
    this.br = br;
    this.cr = cr;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void trx() {
    final var p1 = new Publisher("name-p1", "add-p1");
    cr.save(p1);
    final var a1 = new Author("sebastian", "avila");
    final var b1 = new Book("titulo-1", "isbn-1", p1);
    a1.getBooks().add(b1);
    ar.save(a1);
    b1.getAuthors().add(a1);
    br.save(b1);
    
    final var a2 = new Author("elias", "montecinos");
    final var b2 = new Book("titulo-2", "isbn-2", p1);
    a2.getBooks().add(b2);
    ar.save(a2);
    b2.getAuthors().add(a2);
    br.save(b2);
  }
}
