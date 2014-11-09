package za.ac.cput.mobile.scanner.service.product;

import java.util.List;

import za.ac.cput.mobile.scanner.repository.model.Product;

/**
 * The Interface ProductService.
 */
public interface ProductService {
  
  /**
   * Adds the product.
   *
   * @param product the product
   */
  public void addProduct(Product product);

  /**
   * Update product.
   *
   * @param product the product
   */
  public void updateProduct(Product product);

  /**
   * Gets the product.
   *
   * @param id the id
   * @return the product
   */
  public Product getProduct(Integer id);

  /**
   * Delete product.
   *
   * @param id the id
   */
  public void deleteProduct(Integer id);

  /**
   * Gets the products.
   *
   * @return the products
   */
  public List<Product> getProducts();
  
  /**
   * Gets the product by barcode.
   *
   * @param barcode the barcode
   * @return the product by barcode
   */
  public Product getProductByBarcode(String barcode);

}
