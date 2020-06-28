package lesson6.persist;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int price;

  @ManyToOne
  private Category category;

  public Product(String name, int price, Category category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }
}
