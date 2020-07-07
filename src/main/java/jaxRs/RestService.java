package jaxRs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lesson6.service.ProdRepresentation;
import lesson6.service.ProductService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/")
@Api(value = "RestService")
public class RestService {

  @EJB
  private ProductService productService;

  @DELETE
  @Path("/products/{id}")
  @ApiOperation(value = "Delete product")
  public Response deleteProduct(@ApiParam(name = "id", value = "prod id") @PathParam("id") long id) {
    productService.deleteById(id);
    return Response.accepted().build();
  }

  @POST
  @Path("/prod")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_HTML)
  @ApiOperation(value = "Add new")
  public Response addProduct(@ApiParam(value = "New product to add") ProdRepresentation product) {
    productService.insert(product);
    return Response.accepted("Status: OK").build();
  }

  @GET
  @Path("/")
  @ApiOperation(value = "Check service")
  @Produces(MediaType.TEXT_HTML)
  public Response checkAlive() {
    return Response.ok("I'm alive!").build();
  }

  @GET
  @Path("/allProd")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value = "Get all")
  public Collection<ProdRepresentation> getAllProducts() {
    return productService.findAll();
  }

}
