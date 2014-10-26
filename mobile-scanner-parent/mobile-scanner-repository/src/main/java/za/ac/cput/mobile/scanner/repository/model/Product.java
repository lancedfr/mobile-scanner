package za.ac.cput.mobile.scanner.repository.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
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
  @Column(unique = true)
  private String barcode;
  private String name;
  private String shortDescription;
  private String longDescription;
  private BigDecimal price;
  private String length;
  private String height;
  private String width;
  private String weight;
  private String colour;
  private String modelNumber;
  private String manufacturer;
  private boolean preowned;
  private Date releaseDate;
  private String warranty;
  private String stateCondition;
  private BigDecimal customerReviewAverage;
  private BigInteger customerReviewCount;
  private boolean customerTopRated;

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

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public String getModelNumber() {
    return modelNumber;
  }

  public void setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public boolean isPreowned() {
    return preowned;
  }

  public void setPreowned(boolean preowned) {
    this.preowned = preowned;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getWarranty() {
    return warranty;
  }

  public void setWarranty(String warranty) {
    this.warranty = warranty;
  }

  public String getStateCondition() {
    return stateCondition;
  }

  public void setStateCondition(String stateCondition) {
    this.stateCondition = stateCondition;
  }

  public BigDecimal getCustomerReviewAverage() {
    return customerReviewAverage;
  }

  public void setCustomerReviewAverage(BigDecimal customerReviewAverage) {
    this.customerReviewAverage = customerReviewAverage;
  }

  public BigInteger getCustomerReviewCount() {
    return customerReviewCount;
  }

  public void setCustomerReviewCount(BigInteger customerReviewCount) {
    this.customerReviewCount = customerReviewCount;
  }

  public boolean isCustomerTopRated() {
    return customerTopRated;
  }

  public void setCustomerTopRated(boolean customerTopRated) {
    this.customerTopRated = customerTopRated;
  }
}
