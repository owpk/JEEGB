package security;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
public class User {

  @Id
  private Long id;

  @NotNull
  private String name;

  @NotNull
  @Size(min = 5, message = "5 symbols min length require")
  private String password;

}
