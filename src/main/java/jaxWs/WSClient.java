package jaxWs;

import lesson6.service.ProdRepresentation;

import javax.xml.ws.WebServiceRef;
import java.net.MalformedURLException;

public class WSClient {

  @WebServiceRef(wsdlLocation = "http://localhost:8080/jax-ws/WSService?WSDL")
  public static WSService wsService;

  public static void main(String[] args) throws MalformedURLException {
    wsService.addProd(new ProdRepresentation());
    System.out.println(wsService.getAll());
  }
}
