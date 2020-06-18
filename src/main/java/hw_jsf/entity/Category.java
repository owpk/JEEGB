package hw_jsf.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category implements BaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "category",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Product> products;
}
