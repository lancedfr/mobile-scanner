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
package za.ac.cput.mobile.scanner.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.mobile.scanner.repository.dao.ProductDao;
import za.ac.cput.mobile.scanner.repository.model.Product;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

  /** The product dao. */
  @Autowired
  private ProductDao productDao;

  @Override
  public void addProduct(Product product) {
    productDao.addProduct(product);
  }

  @Override
  public void updateProduct(Product product) {
    productDao.updateProduct(product);
  }

  @Override
  public Product getProduct(Integer id) {
    return productDao.getProduct(id);
  }

  @Override
  public void deleteProduct(Integer id) {
    productDao.deleteProduct(id);
  }

  @Override
  public List<Product> getProducts() {
    return productDao.getProducts();
  }

  @Override
  public Product getProductByBarcode(String barcode) {
    return productDao.getProductByBarcode(barcode);
  }

}
