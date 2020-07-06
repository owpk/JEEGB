package lesson6.persist;

import lesson6.service.ProdRepresentation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductRepo extends BaseRepo<Product> {

  @PersistenceContext(unitName = "p-unit")
  protected EntityManager em;

  public ProdRepresentation findProdRepresentationById(long id) {
    return em.createQuery("select new lesson6.service.ProdRepresentation(t.id, t.name, t.price, t.category.id, t.category.name) from Product t where t.id = :id", ProdRepresentation.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  public List<Product> findAll() {
    return em.createQuery("from Product", Product.class).getResultList();
  }

  public List<ProdRepresentation> findAllProductRepresentation() {
    return em.createQuery("select new lesson6.service.ProdRepresentation(t.id, t.name, t.price, t.category.id, t.category.name) from Product t", ProdRepresentation.class)
        .getResultList();
  }

  @Override
  public void deleteById(long id) {
    Product product = em.find(Product.class, id);
    if (product!= null) {
      em.remove(product);
    }
  }

  @Override
  public Product findById(long id) {
    return em.find(Product.class, id);
  }

}
