package test;

import hw_jsf.entity.Category;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class CategoryRepo extends BaseRepo<Category> implements Serializable {

    public List<Category> getCategoryList() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }

}
