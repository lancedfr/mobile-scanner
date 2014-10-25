package za.ac.cput.mobile.scanner.repository;

import static org.junit.Assert.assertEquals;

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
public class ProductDaoImplIT {

  @Autowired
  private ProductDao productDao;
  private Product product;

  @Before
  public void before() {
    product = new Product();
    product.setBarcode("99999");
    product.setName("Lance");
  }

  @Test
  public void testGetProduct() throws Exception {
    productDao.addProduct(product);
    Product getProduct = productDao.getProduct(1);
    assertEquals(product.getBarcode(), getProduct.getBarcode());
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
    assertEquals(1, products.size());
  }

  @Test
  public void testDeleteProduct() throws Exception {
    productDao.deleteProduct(1);
    List<Product> products = productDao.getProducts();
    assertEquals(0, products.size());
  }
  
  @Test
  public void testGetProductByBarcode() throws Exception {
    productDao.addProduct(product);
    List<Product> products = productDao.getProducts();
    assertEquals(1, products.size());
    Product productByBarcode = productDao.getProductByBarcode(product.getBarcode());
    assertEquals(productByBarcode.getBarcode(), product.getBarcode());
  }
  
  @Test
  public void testAddSameProduct() throws Exception {
    productDao.addProduct(product);
    productDao.addProduct(product);
    Product productByBarcode = productDao.getProductByBarcode(product.getBarcode());
    assertEquals(productByBarcode.getBarcode(), product.getBarcode());
    productDao.addProduct(productByBarcode);
    List<Product> products = productDao.getProducts();
    assertEquals(1, products.size());
  }

}
