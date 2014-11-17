/**
 * EFD (Economic Freedom Developers) 
 * (Lance Reid, Nash Naidoo, Flippie van Schalkwyk, Tohhier Allie)
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package za.ac.cput.mobile.scanner.repository.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name = "product")
public class Product {

  /** The id. */
  @Id
  @GeneratedValue
  private Integer id;

  /** The barcode. */
  @Column(unique = true)
  private String barcode;

  /** The name. */
  private String name;

  /** The short description. */
  private String shortDescription;

  /** The long description. */
  private String longDescription;

  /** The price. */
  private BigDecimal price;

  /** The length. */
  private String length;

  /** The height. */
  private String height;

  /** The width. */
  private String width;

  /** The weight. */
  private String weight;

  /** The colour. */
  private String colour;

  /** The model number. */
  private String modelNumber;

  /** The manufacturer. */
  private String manufacturer;

  /** The preowned. */
  private boolean preowned;

  /** The release date. */
  private Date releaseDate;

  /** The warranty. */
  private String warranty;

  /** The state condition. */
  private String stateCondition;

  /** The customer review average. */
  private BigDecimal customerReviewAverage;

  /** The customer review count. */
  private BigInteger customerReviewCount;

  /** The customer top rated. */
  private boolean customerTopRated;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Gets the barcode.
   *
   * @return the barcode
   */
  public String getBarcode() {
    return barcode;
  }

  /**
   * Sets the barcode.
   *
   * @param barcode
   *          the new barcode
   */
  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the short description.
   *
   * @return the short description
   */
  public String getShortDescription() {
    return shortDescription;
  }

  /**
   * Sets the short description.
   *
   * @param shortDescription
   *          the new short description
   */
  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  /**
   * Gets the long description.
   *
   * @return the long description
   */
  public String getLongDescription() {
    return longDescription;
  }

  /**
   * Sets the long description.
   *
   * @param longDescription
   *          the new long description
   */
  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public BigDecimal getPrice() {
    return price;
  }

  /**
   * Sets the price.
   *
   * @param price
   *          the new price
   */
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  /**
   * Gets the length.
   *
   * @return the length
   */
  public String getLength() {
    return length;
  }

  /**
   * Sets the length.
   *
   * @param length
   *          the new length
   */
  public void setLength(String length) {
    this.length = length;
  }

  /**
   * Gets the height.
   *
   * @return the height
   */
  public String getHeight() {
    return height;
  }

  /**
   * Sets the height.
   *
   * @param height
   *          the new height
   */
  public void setHeight(String height) {
    this.height = height;
  }

  /**
   * Gets the width.
   *
   * @return the width
   */
  public String getWidth() {
    return width;
  }

  /**
   * Sets the width.
   *
   * @param width
   *          the new width
   */
  public void setWidth(String width) {
    this.width = width;
  }

  /**
   * Gets the weight.
   *
   * @return the weight
   */
  public String getWeight() {
    return weight;
  }

  /**
   * Sets the weight.
   *
   * @param weight
   *          the new weight
   */
  public void setWeight(String weight) {
    this.weight = weight;
  }

  /**
   * Gets the colour.
   *
   * @return the colour
   */
  public String getColour() {
    return colour;
  }

  /**
   * Sets the colour.
   *
   * @param colour
   *          the new colour
   */
  public void setColour(String colour) {
    this.colour = colour;
  }

  /**
   * Gets the model number.
   *
   * @return the model number
   */
  public String getModelNumber() {
    return modelNumber;
  }

  /**
   * Sets the model number.
   *
   * @param modelNumber
   *          the new model number
   */
  public void setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
  }

  /**
   * Gets the manufacturer.
   *
   * @return the manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Sets the manufacturer.
   *
   * @param manufacturer
   *          the new manufacturer
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Checks if is preowned.
   *
   * @return true, if is preowned
   */
  public boolean isPreowned() {
    return preowned;
  }

  /**
   * Sets the preowned.
   *
   * @param preowned
   *          the new preowned
   */
  public void setPreowned(boolean preowned) {
    this.preowned = preowned;
  }

  /**
   * Gets the release date.
   *
   * @return the release date
   */
  public Date getReleaseDate() {
    return releaseDate;
  }

  /**
   * Sets the release date.
   *
   * @param releaseDate
   *          the new release date
   */
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * Gets the warranty.
   *
   * @return the warranty
   */
  public String getWarranty() {
    return warranty;
  }

  /**
   * Sets the warranty.
   *
   * @param warranty
   *          the new warranty
   */
  public void setWarranty(String warranty) {
    this.warranty = warranty;
  }

  /**
   * Gets the state condition.
   *
   * @return the state condition
   */
  public String getStateCondition() {
    return stateCondition;
  }

  /**
   * Sets the state condition.
   *
   * @param stateCondition
   *          the new state condition
   */
  public void setStateCondition(String stateCondition) {
    this.stateCondition = stateCondition;
  }

  /**
   * Gets the customer review average.
   *
   * @return the customer review average
   */
  public BigDecimal getCustomerReviewAverage() {
    return customerReviewAverage;
  }

  /**
   * Sets the customer review average.
   *
   * @param customerReviewAverage
   *          the new customer review average
   */
  public void setCustomerReviewAverage(BigDecimal customerReviewAverage) {
    this.customerReviewAverage = customerReviewAverage;
  }

  /**
   * Gets the customer review count.
   *
   * @return the customer review count
   */
  public BigInteger getCustomerReviewCount() {
    return customerReviewCount;
  }

  /**
   * Sets the customer review count.
   *
   * @param customerReviewCount
   *          the new customer review count
   */
  public void setCustomerReviewCount(BigInteger customerReviewCount) {
    this.customerReviewCount = customerReviewCount;
  }

  /**
   * Checks if the customer is top rated.
   *
   * @return true, if is customer top rated
   */
  public boolean isCustomerTopRated() {
    return customerTopRated;
  }

  /**
   * Sets the customer top rated.
   *
   * @param customerTopRated
   *          the new customer top rated
   */
  public void setCustomerTopRated(boolean customerTopRated) {
    this.customerTopRated = customerTopRated;
  }
}
