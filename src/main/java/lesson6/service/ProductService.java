package lesson6.service;

import lesson6.persist.Category;
import lesson6.persist.CategoryRepo;
import lesson6.persist.Product;
import lesson6.persist.ProductRepo;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProductService {

  @Inject
  private ProductRepo productRepo;

  @Inject
  private CategoryRepo categoryRepo;

  @TransactionAttribute
  public void insert(ProdRepresentation prodRepresentation) {
    Category category = categoryRepo.findById(prodRepresentation.getCategory_id());
    productRepo.insert(new Product(prodRepresentation.getName(), prodRepresentation.getPrice(), category));
  }

  public List<ProdRepresentation> findAll() {
    return productRepo.findAllProductRepresentation();
  }
}
