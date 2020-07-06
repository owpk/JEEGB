package lesson6.controller;

import lesson6.persist.Product;
import lesson6.service.ProdRepresentation;
import lesson6.service.ProductService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

  @EJB
  private ProductService productService;

  @PostConstruct
  public void init() {
    this.products = productService.findAll();
    System.out.println(products);
  }

  private List<ProdRepresentation> products;

  private Product product;

  public List<ProdRepresentation> getProdList() {
    return products;
  }
}
