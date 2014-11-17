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
package za.ac.cput.mobile.scanner.server.resources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import za.ac.cput.mobile.scanner.repository.model.Product;
import za.ac.cput.mobile.scanner.service.product.ProductService;

/**
 * Handles requests for the Product service.
 */
@Controller
public class ProductResource {
  
  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

  /** The product service. */
  @Autowired
  private ProductService productService;

  /**
   * Gets a dummy product for testing.
   *
   * @return the dummy product
   */
  @ResponseBody
  @RequestMapping(value = "/rest/product/dummy", method = RequestMethod.GET)
  public Product getDummyProduct() {
    LOGGER.info("Start getDummyProduct");
    Product product = new Product();
    product.setBarcode("99999999");
    product.setColour("Blue");
    product.setCustomerReviewAverage(BigDecimal.valueOf(4.5));
    product.setCustomerReviewCount(BigInteger.valueOf(397));
    product.setCustomerTopRated(true);
    product.setHeight("200cm");
    product.setLength("160cm");
    product.setLongDescription("longDescription");
    product.setManufacturer("South Shoes");
    product.setModelNumber("M384-e");
    product.setName("Dummy");
    product.setPreowned(false);
    product.setPrice(BigDecimal.valueOf(5329.99));
    product.setReleaseDate(new Date());
    product.setShortDescription("shortDescription");
    product.setStateCondition("New");
    product.setWarranty("2 Year");
    product.setWeight("600g");
    product.setWidth("100cm");
    productService.addProduct(product);
    return product;
  }

  /**
   * Gets the product.
   *
   * @param productId the product id
   * @return the product
   */
  @ResponseBody
  @RequestMapping(value = "/rest/product/{id}", method = RequestMethod.GET)
  public Product getProduct(@PathVariable("id") int productId) {
    LOGGER.info("Start getProduct. ID=" + productId);
    return productService.getProduct(productId);
  }

  /**
   * Gets all the products.
   *
   * @return all the products
   */
  @ResponseBody
  @RequestMapping(value = "/rest/products", method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    LOGGER.info("Start getAllProducts.");
    return productService.getProducts();
  }

  /**
   * Creates the product.
   *
   * @param product the product
   * @return the product
   */
  @ResponseBody
  @RequestMapping(value = "/rest/product", method = RequestMethod.POST)
  public Product createProduct(@RequestBody Product product) {
    LOGGER.info("Start createProduct.");
    productService.addProduct(product);
    return product;
  }

  /**
   * Delete product.
   *
   * @param productId the product id
   * @return the product
   */
  @ResponseBody
  @RequestMapping(value = "/rest/product/{id}", method = RequestMethod.DELETE)
  public Product deleteProduct(@PathVariable("id") int productId) {
    LOGGER.info("Start deleteProduct.");
    productService.deleteProduct(productId);
    return new Product();
  }
  
  /**
   * Gets the product by barcode.
   *
   * @param barcode the barcode
   * @return the product by barcode
   */
  @ResponseBody
  @RequestMapping(value = "/rest/product", method = RequestMethod.GET)
  public Product getProductByBarcode(@RequestParam(value="barcode", required=true) String barcode) {
    LOGGER.info("Start getProduct. barcode=" + barcode);
    return productService.getProductByBarcode(barcode);
  }

}
