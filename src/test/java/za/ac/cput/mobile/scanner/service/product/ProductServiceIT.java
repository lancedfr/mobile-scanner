package za.ac.cput.mobile.scanner.service.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import za.ac.cput.mobile.scanner.repository.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context-test.xml", "classpath:repository-context-test.xml"})
public class ProductServiceIT {
  
  @Autowired
  private ProductService productService;

  @Test
  public void test() {
    Product product = new Product();
    product.setBarcode("1234123123");
    product.setName("Lance");
    productService.addProduct(product);
    List<Product> products = productService.getProducts();
    assertEquals(1, products.size());
  }

}
