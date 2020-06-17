package hw_jsf.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class User implements BaseItem {

    private static final byte passLength = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    @NotNull(message = "Field should not be empty")
    private String name;

    @Column(name = "password")
    @NotNull(message = "Field should not be empty")
    @Pattern(regexp = "(\\w+){" + passLength + ",}", message = "minimum length required: " + passLength)
    private String password;

}
