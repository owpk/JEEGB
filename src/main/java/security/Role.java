package security;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role implements Serializable {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  public Role() {

  }

  public Role(Role r) {
    this.id = r.getId();
    this.name = r.getName();
  }
}
