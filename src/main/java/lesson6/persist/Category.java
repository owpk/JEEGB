package lesson6.persist;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> categories;

}
