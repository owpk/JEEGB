package security;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;

@SessionScoped
@Named
public class AuthService implements Serializable {
  private User user;

  public User getUser() {
    return user;
  }

  private void login() {

  }
}
