package security;

import lombok.NoArgsConstructor;

import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@NoArgsConstructor
public class UserRepo {

  @PersistenceContext(unitName = "p-unit")
  protected EntityManager em;


  public User findById(int id) {
    return em.find(User.class, id);
  }

  public boolean existsById(int id) {
    return findById(id) != null;
  }

  @TransactionAttribute
  public List<User> getAllUsers() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<User> query = cb.createQuery(User.class);
    Root<User> from = query.from(User.class);
    from.fetch("roles", JoinType.LEFT);
    query.select(from).distinct(true);
    return em.createQuery(query).getResultList();
  }
}
