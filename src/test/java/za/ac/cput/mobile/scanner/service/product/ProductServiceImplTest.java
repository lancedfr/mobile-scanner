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

}
