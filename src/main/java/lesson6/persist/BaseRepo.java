package lesson6.persist;

import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepo<T> {

  @PersistenceContext(unitName = "p-unit")
  protected EntityManager em;

  @TransactionAttribute
  public void insert(T t) {
    em.persist(t);
  }

  @TransactionAttribute
  public void update(T t) {
    em.merge(t);
  }

  @TransactionAttribute
  public abstract void deleteById(long id);
  public abstract T findById(long id);

}
