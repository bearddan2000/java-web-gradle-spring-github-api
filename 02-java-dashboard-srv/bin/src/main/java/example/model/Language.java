package example.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "lang")
public class Language implements Serializable
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  Long id;

  String name;

  private static final long serialVersionUID = 1L;

  public Language() {
      super();
  }

  public Language(final String name) {
      super();
      this.name = name;
  }

  public Long getId() {
         return id;
     }

  public void setId(final Long id) {
   this.id = id;
  }

  public String getName() {
   return name;
  }

  public void setName(final String name) {
   this.name = name;
  }

  @Override
  public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + ((name == null) ? 0 : name.hashCode());
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
   final Language other = (Language) obj;
   if (name == null) {
       if (other.name != null)
           return false;
   } else if (!name.equals(other.name))
       return false;
   return true;
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("[OUTPUT] ");
    sb.append(String.format("name=%s ", name));

    return sb.toString();
  }

}
