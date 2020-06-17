package hw_jsf.repos;

import hw_jsf.entity.Product;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class ProductRepo extends BaseRepository<Product> {

    @Override
    public Product getById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Collection<Product> getAll() {

        // Пример использования Criteria API
        // Эквивалентен JPQL запросу entityManager.createQuery("select p from Product p", Product.class).getResultList();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public long count() {
        return (Long) entityManager.createQuery("select count(*) from Product p")
                .getSingleResult();
    }

    public Collection<Product> getByCategory(long categoryId) {
        return entityManager.createQuery("select p from Product p where p.category.id = :id", Product.class)
                .setParameter("id", categoryId)
                .getResultList();
    }
}

