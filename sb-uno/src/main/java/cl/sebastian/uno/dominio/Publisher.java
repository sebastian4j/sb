package cl.sebastian.uno.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String address;

  public Publisher() {}

  public Publisher(final String name, final String address) {
    super();
    this.name = name;
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(final String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(final String address) {
    this.address = address;
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
    final Publisher other = (Publisher) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Publisher [id=" + id + ", name=" + name + ", address=" + address + "]";
  }


}
