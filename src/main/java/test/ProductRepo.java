package test;

import hw_jsf.entity.BaseItem;
import hw_jsf.entity.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProductRepo extends AbsRepo<Product> implements Serializable {

    public List<Product> getJPQLAll() {
        Query query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> list = query.getResultList();
        return list;
    }

}
