package cl.sebastian.uno.dominio;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private String isbn;
  @OneToOne
  private Publisher publisher;
  @ManyToMany
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<Author> authors = new HashSet<>();

  public Book() {}

  public Book(final String title, final String isbn, final Publisher publisher) {
    super();
    this.title = title;
    this.isbn = isbn;
    this.publisher = publisher;
  }
  public Book(final String title, final String isbn, final Publisher publisher, final Set<Author> authors) {
    super();
    this.title = title;
    this.isbn = isbn;
    this.publisher = publisher;
    this.authors = authors;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(final String title) {
    this.title = title;
  }
  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(final String isbn) {
    this.isbn = isbn;
  }
  public Publisher getPublisher() {
    return publisher;
  }
  public void setPublisher(final Publisher publisher) {
    this.publisher = publisher;
  }
  public Set<Author> getAuthors() {
    return authors;
  }
  public void setAuthors(final Set<Author> authors) {
    this.authors = authors;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher
        + ", authors=" + authors + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Book other = (Book) obj;
    if (id != other.id)
      return false;
    return true;
  }
}
