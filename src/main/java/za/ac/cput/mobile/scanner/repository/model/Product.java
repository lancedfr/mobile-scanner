package za.ac.cput.mobile.scanner.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue
  private Integer id;
  private String barcode;
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}