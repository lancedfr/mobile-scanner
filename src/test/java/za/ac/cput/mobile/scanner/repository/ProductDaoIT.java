package za.ac.cput.mobile.scanner.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

  @Test
  public void test() {
    Product product = new Product();
    product.setBarcode("1234123123");
    product.setName("Lance");
    productDao.addProduct(product);
    List<Product> products = productDao.getProducts();
    assertEquals(1, products.size());
  }

}
