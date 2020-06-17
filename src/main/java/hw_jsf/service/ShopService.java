package hw_jsf.service;

import hw_jsf.models.Product;
import hw_jsf.repos.BaseRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ShopService {

    @PostConstruct
    public void init() {
        product = new Product();
    }

    @Inject
    private BaseRepository<Product> catalogRepository;

    private Product product;

    public void addProduct() {
        catalogRepository.add(this.product);
    }

    public List<Product> getProductList() {
        return catalogRepository.itemList();
    }

    public void deleteProduct(Product product) {
        catalogRepository.remove(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
