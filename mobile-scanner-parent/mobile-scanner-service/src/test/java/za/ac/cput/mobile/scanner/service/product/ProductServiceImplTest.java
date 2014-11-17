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

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import za.ac.cput.mobile.scanner.repository.dao.ProductDao;
import za.ac.cput.mobile.scanner.repository.model.Product;

public class ProductServiceImplTest {

  @Mock
  private ProductDao productDao;
  @Mock
  private Product product;

  @InjectMocks
  private ProductService productService;

  @Before
  public void before() {
    productService = new ProductServiceImpl();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAddProduct() {
    productService.addProduct(product);
    verify(productDao, times(1)).addProduct(product);
  }

  @Test
  public void testDeleteProduct() {
    productService.deleteProduct(1);
    verify(productDao, times(1)).deleteProduct(1);
  }

  @Test
  public void testGetProduct() {
    when(productDao.getProduct(1)).thenReturn(product);
    Product getProduct = productService.getProduct(1);
    assertEquals(getProduct, product);
  }
  
  @Test
  public void testGetProducts() {
    List<Product> products = Arrays.asList(product, product);
    when(productDao.getProducts()).thenReturn(products);
    List<Product> getProducts = productService.getProducts();
    assertEquals(getProducts, products);
    assertEquals(getProducts.size(), 2);
  }
  
  @Test
  public void testUpdateProduct() {
    productService.updateProduct(product);
    verify(productDao, times(1)).updateProduct(product);
  }

  @Test
  public void testGetProductByBarcode() {
    when(productDao.getProductByBarcode(anyString())).thenReturn(product);
    Product getProduct = productService.getProductByBarcode("anybarcode");
    assertEquals(getProduct, product);
  }
}
