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
