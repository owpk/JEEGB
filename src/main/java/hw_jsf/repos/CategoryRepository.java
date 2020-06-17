package hw_jsf.repos;


import hw_jsf.entity.Category;

import java.io.Serializable;
import java.util.Collection;


public class CategoryRepository extends BaseRepository<Category> implements Serializable {

    @Override
    public Collection<Category> getAll() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Override
    public long count() {
        return (Long) entityManager.createQuery("select count(*) from Category c")
                .getSingleResult();
    }

    @Override
    public Category getById(long id) {
        return entityManager.find(Category.class, id);
    }
}

