package hw_servlets;

import javax.persistence.*;

@Entity
//@Table(name = "catalog")
public class CatalogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column (name = "id")
    private int id;

    //@Column(name = "name")
    private String name;

    //@Column(name = "cost")
    private int cost;

    //@Column(name = "description")
    private String description;

    public CatalogModel() {

    }

    public CatalogModel(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "POJOClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }


}