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

package za.ac.cput.mobile.scanner.repository.dao;

import java.util.List;

import za.ac.cput.mobile.scanner.repository.model.Product;

/**
 * The Interface ProductDao.
 */
public interface ProductDao {

  /**
   * Adds the product if the barcode <b>does not</b> already exist. Otherwise
   * the product will be updated.
   *
   * @param product
   *          the product
   */
  public void addProduct(Product product);

  /**
   * Update product.
   *
   * @param product
   *          the product
   */
  public void updateProduct(Product product);

  /**
   * Gets the product.
   *
   * @param id
   *          the id
   * @return the product
   */
  public Product getProduct(Integer id);

  /**
   * Delete product.
   *
   * @param id
   *          the id
   */
  public void deleteProduct(Integer id);

  /**
   * Gets the products.
   *
   * @return the products
   */
  public List<Product> getProducts();

  /**
   * Gets the product by barcode.
   *
   * @param barcode
   *          the barcode
   * @return the product by barcode
   */
  public Product getProductByBarcode(String barcode);

}
