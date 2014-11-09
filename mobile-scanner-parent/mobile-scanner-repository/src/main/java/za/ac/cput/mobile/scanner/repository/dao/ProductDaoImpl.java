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
