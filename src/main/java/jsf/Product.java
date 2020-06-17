package jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


public class Product {
    private int price;
    private String name;

    public Product(){
        this.price = 100;
        this.name = "FirstProduct";
    }

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
