package za.ac.cput.mobile.scanner.repository.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.mobile.scanner.repository.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  public void addProduct(Product product) {
    getCurrentSession().save(product);
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
    return getCurrentSession().createQuery("from Product").list();
  }

}
