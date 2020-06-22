package test;

import hw_jsf.entity.BaseItem;
import hw_jsf.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class BaseRepo<T extends BaseItem> {

    @PersistenceContext(unitName = "ds")
    protected EntityManager entityManager;

    public Product getById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        entityManager.remove(getById(id));
    }

    @Transactional
    public void delete(T element) {
        if (element != null)
        entityManager.remove(element);
    }

    @Transactional
    public void add(T element) {
        if (element != null)
        entityManager.persist(element);
    }

    @Transactional
    public void merge(T element) {
        entityManager.merge(element);
    }
}
