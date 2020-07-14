package security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

  @Id
  private Long id;

  @NotNull
  private String name;

  @NotNull
  @Size(min = 5, message = "5 symbols min length require")
  private String password;

  public User(User u) {
    this.id = u.getId();
    this.name = u.getName();
    this.password = u.getPassword();
  }

}
