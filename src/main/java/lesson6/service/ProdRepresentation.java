package lesson6.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdRepresentation implements Serializable {
  private int id;
  private String name;
  private int price;
  private int category_id;
  private String cat_name;
}
