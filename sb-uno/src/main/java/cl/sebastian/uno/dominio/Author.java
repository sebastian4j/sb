package cl.sebastian.uno.dominio;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Author () {}

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public void setBooks(final Set<Book> books) {
    this.books = books;
  }

  public Author(final String firstName, final String lastName, final Set <Book> books) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.books = books;
  }

  public Author(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }
  public Set<Book> getBooks() {
    return books;
  }

  @Override
  public String toString() {
    return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books="
        + books + "]";
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
    final Author other = (Author) obj;
    if (id != other.id)
      return false;
    return true;
  }
}
