package security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoleRepo {

  @PersistenceContext(unitName = "p-unit")
  protected EntityManager em;

  public Role findById(int id) {
    return em.find(Role.class, id);
  }

  public List<Role> getAllRoles() {
    return em.createQuery("from Role ", Role.class).getResultList();
  }
}
