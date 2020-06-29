package lesson6.controller;

import lesson6.service.CartService;
import lesson6.service.ProdRepresentation;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

  @EJB
  private CartService cartService;

  public void add(ProdRepresentation prod) {
    cartService.add(prod);
  }

  public List<ProdRepresentation> getAllUserProd() {
    return cartService.getCart();
  }

}
