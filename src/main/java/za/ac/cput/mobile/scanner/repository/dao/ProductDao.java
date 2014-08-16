package za.ac.cput.mobile.scanner.repository.dao;

import java.util.List;

import za.ac.cput.mobile.scanner.repository.model.Product;

public interface ProductDao {

  public void addProduct(Product product);

  public void updateProduct(Product product);

  public Product getProduct(Integer id);

  public void deleteProduct(Integer id);

  public List<Product> getProducts();

}
