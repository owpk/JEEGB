package lesson6.persist;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryRepo extends BaseRepo<Category>{

  public List<Category> findAll() {
    return em.createQuery("from Category ", Category.class).getResultList();
  }

  @Override
  public void deleteById(long id) {
    Category category = em.find(Category.class, id);
    if (category!= null) {
      em.remove(category);
    }
  }

  @Override
  public Category findById(long id) {
    return em.find(Category.class, id);
  }

}
