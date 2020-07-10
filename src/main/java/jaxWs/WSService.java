package jaxWs;

import hw_jsf.entity.Product;
import lesson6.service.ProdRepresentation;
import lesson6.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "jaxWs.WSService")
public class WSService {

  private static Logger logger = LoggerFactory.getLogger(WSService.class);

  @EJB
  private ProductService productService;

  public void addProd(ProdRepresentation product) {
    productService.insert(product);
  }

  public List<ProdRepresentation> getAll() {
    return productService.findAll();
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8081/WSService", new WSService());
  }
}


