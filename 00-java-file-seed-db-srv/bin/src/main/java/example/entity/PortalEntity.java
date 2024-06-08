package example.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true, optimisticLock = OptimisticLockType.ALL)
@Table(name = "main", uniqueConstraints = {@UniqueConstraint(columnNames = "id") })
@Getter
@Setter
@NoArgsConstructor
public class PortalEntity implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  Long id;
  Integer isDev = 0;
  String name;
  String description = "-";
  Integer additionId = 0;

  @Column(name="url")
  String clone_url;

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("[OUTPUT] ");
    sb.append(String.format("dev=%d, ", isDev));
    sb.append(String.format("name=%s, ", name));
    sb.append(String.format("description=%s, ", description));
    sb.append(String.format("addition=%d, ", additionId));
    sb.append(String.format("downloadsUrl=%s", clone_url));

    return sb.toString();
  }

}
