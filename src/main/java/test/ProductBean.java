package test;

import hw_jsf.entity.Category;
import hw_jsf.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named("prod_bean")
@SessionScoped
public class ProductBean implements Serializable {

    @Inject
    private ProductRepo productRepo;

    @Inject
    private CategoryRepo categoryRepo;

    private Collection<Category> categoryList;
    private Collection<Product> productsList;
    private Category category;

    @PostConstruct
    private void init() {
        categoryList = categoryRepo.getCategoryList();
        productsList = productRepo.getJPQLAll();
    }


    public Collection<Category> getCategoryList() {
        return categoryList;
    }

    public Collection<Product> getProductsList() {
        return productsList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
