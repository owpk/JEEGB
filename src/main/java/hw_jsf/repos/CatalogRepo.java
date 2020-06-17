package hw_jsf.repos;


import hw_jsf.models.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CatalogRepo extends BaseRepository<Product> {

    @Override
    protected String obtainName() {
        return Product.class.getName();
    }
}
