package security;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;

@SessionScoped
@Named
public class AuthService implements Serializable {

  @EJB
  private UserService us;

  private User user;

  public User getUser() {
    return user;
  }

  private boolean login(User u) {
    return us.existsById(u.getId());
  }
}
