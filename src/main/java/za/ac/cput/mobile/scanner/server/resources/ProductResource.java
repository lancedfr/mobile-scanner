package za.ac.cput.mobile.scanner.server.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import za.ac.cput.mobile.scanner.repository.model.Product;
import za.ac.cput.mobile.scanner.service.product.ProductService;

/**
 * Handles requests for the Product service.
 */
@Controller
public class ProductResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

  @Autowired
  private ProductService productService;

  @ResponseBody
  @RequestMapping(value = ProductRestURIConstants.DUMMY_PRODUCT, method = RequestMethod.GET)
  public Product getDummyProduct() {
    LOGGER.info("Start getDummyProduct");
    Product product = new Product();
    product.setId(9999);
    product.setBarcode("99999999");
    product.setName("Dummy");
    productService.addProduct(product);
    return product;
  }

  @ResponseBody
  @RequestMapping(value = ProductRestURIConstants.GET_PRODUCT, method = RequestMethod.GET)
  public Product getProduct(@PathVariable("id") int productId) {
    LOGGER.info("Start getProduct. ID=" + productId);
    return productService.getProduct(productId);
  }

  @ResponseBody
  @RequestMapping(value = ProductRestURIConstants.GET_ALL_PRODUCT, method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    LOGGER.info("Start getAllProducts.");
    return productService.getProducts();
  }

  @ResponseBody
  @RequestMapping(value = ProductRestURIConstants.CREATE_PRODUCT, method = RequestMethod.POST)
  public Product createProduct(@RequestBody Product product) {
    LOGGER.info("Start createProduct.");
    productService.addProduct(product);
    return product;
  }

  @ResponseBody
  @RequestMapping(value = ProductRestURIConstants.DELETE_PRODUCT, method = RequestMethod.DELETE)
  public Product deleteProduct(@PathVariable("id") int productId) {
    LOGGER.info("Start deleteProduct.");
    productService.deleteProduct(productId);
    return new Product();
  }

}
