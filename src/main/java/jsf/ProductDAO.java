package jsf;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
@Data
public class ProductDAO {
    private String name;
    private List<Product> list;

    public ProductDAO() {
        list = new ArrayList<>();
        list.add(new Product(123, "Poop"));
        list.add(new Product(1000,"IPoop"));
    }

    public String doAction() {
        return "/jsf_pages/result.xhtml";
    }

    public void delete(Product product) {
        list.remove(product);
    }

    public void add(Product p) {
        list.add(p);
    }
}
