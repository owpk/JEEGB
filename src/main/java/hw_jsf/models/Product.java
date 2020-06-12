package hw_jsf;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "catalog")
@Data
@NoArgsConstructor
public class Product implements BaseItem{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    @NotNull(message = "Field should not be empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Field should not be empty")
    @Pattern(regexp = "\\d+", message = "Digits only allowed")
    @Column(name = "cost")
    private String cost;

    @Column(name = "description")
    private String description;

}