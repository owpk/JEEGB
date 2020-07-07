package jaxWs;

import lesson6.persist.Product;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.spi.ObjectFactory;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService(name = "IProduct", targetNamespace = "http://ws.jax.jsflesson.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IProduct {
  /**
   *
   * @return
   *     returns java.util.List<com.jsflesson.jax.ws.Product>
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(localName = "getProduct", targetNamespace = "http://ws.jax.jsflesson.com/", className = "com.jsflesson.jax.ws.GetProduct")
  @ResponseWrapper(localName = "getProductResponse", targetNamespace = "http://ws.jax.jsflesson.com/", className = "com.jsflesson.jax.ws.GetProductResponse")
  @Action(input = "http://ws.jax.jsflesson.com/IProduct/getProductRequest", output = "http://ws.jax.jsflesson.com/IProduct/getProductResponse")
  public List<Product> getProduct();

}
