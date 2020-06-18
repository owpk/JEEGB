package hw_jsf.bean;

import hw_jsf.repos.ProductRepo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("prod")
@SessionScoped
public class ProductBean implements Serializable {

    @Inject
    private ProductRepo productRepo;



}
