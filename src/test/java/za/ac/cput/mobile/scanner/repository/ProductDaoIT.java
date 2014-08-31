package za.ac.cput.mobile.scanner.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import za.ac.cput.mobile.scanner.repository.dao.ProductDao;
import za.ac.cput.mobile.scanner.repository.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:repository-context-test.xml")
public class ProductDaoIT {

  @Autowired
  private ProductDao productDao;
  private Product product;

  @Before
  public void before() {
    product = new Product();
    product.setBarcode("1234123123");
    product.setName("Lance");
  }

  @Test
  public void testGetProduct() throws Exception {
    productDao.addProduct(product);
    Product getProduct = productDao.getProduct(1);
    assertEquals("1234123123", getProduct.getBarcode());
  }

  @Test
  public void testUpdateProduct() throws Exception {
    Product getProduct1 = productDao.getProduct(1);
    getProduct1.setName("Other");
    productDao.updateProduct(getProduct1);
    Product getProduct2 = productDao.getProduct(1);
    assertEquals("Other", getProduct2.getName());
  }

  @Test
  public void testAddProduct() {
    productDao.addProduct(product);
    List<Product> products = productDao.getProducts();
    assertEquals(2, products.size());
  }

  @Test
  public void testDeleteProduct() throws Exception {
    productDao.deleteProduct(1);
    List<Product> products = productDao.getProducts();
    assertEquals(1, products.size());
  }

}
