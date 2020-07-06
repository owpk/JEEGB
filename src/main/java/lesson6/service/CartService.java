package lesson6.service;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Data
public class CartService implements Serializable {

  @PostConstruct
  public void init() {
    cart = new ArrayList<>();
  }

  private List<ProdRepresentation> cart;

  public void add(ProdRepresentation prod) {
    cart.add(prod);
  }

}