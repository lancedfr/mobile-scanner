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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.mobile.scanner.repository.model.Product;

/**
 * The Class ProductDaoImpl.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

  /** The session factory. */
  @Autowired
  private SessionFactory sessionFactory;

  /**
   * Gets the current session.
   *
   * @return the current session
   */
  private Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  public void addProduct(Product product) {
    Product productByBarcode = getProductByBarcode(product.getBarcode());
    if (productByBarcode == null) {
      getCurrentSession().save(product);
    } else {
      product.setId(productByBarcode.getId());
      updateProduct(product);
    }
  }

  public void updateProduct(Product product) {
    Product productToUpdate = getProduct(product.getId());
    productToUpdate.setName(product.getName());
    getCurrentSession().update(productToUpdate);
  }

  public Product getProduct(Integer id) {
    return (Product) getCurrentSession().get(Product.class, id);
  }

  public void deleteProduct(Integer id) {
    Product product = getProduct(id);
    if (product != null) {
      getCurrentSession().delete(product);
    }
  }

  @SuppressWarnings("unchecked")
  public List<Product> getProducts() {
    return getCurrentSession().createCriteria(Product.class).list();
  }

  @Override
  public Product getProductByBarcode(String barcode) {
    return (Product) getCurrentSession().createCriteria(Product.class)
        .add(Restrictions.eq("barcode", barcode)).uniqueResult();
  }

}
