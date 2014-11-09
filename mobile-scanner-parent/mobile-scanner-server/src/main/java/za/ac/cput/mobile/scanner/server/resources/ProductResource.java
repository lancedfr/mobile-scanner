package za.ac.cput.mobile.scanner.server.resources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  @RequestMapping(value = "/rest/product/dummy", method = RequestMethod.GET)
  public Product getDummyProduct() {
    LOGGER.info("Start getDummyProduct");
    Product product = new Product();
    product.setBarcode("99999999");
    product.setColour("Blue");
    product.setCustomerReviewAverage(BigDecimal.valueOf(4.5));
    product.setCustomerReviewCount(BigInteger.valueOf(397));
    product.setCustomerTopRated(true);
    product.setHeight("200cm");
    product.setLength("160cm");
    product.setLongDescription("For Kim");
    product.setManufacturer("South Shoes");
    product.setModelNumber("M384-e");
    product.setName("Dummy");
    product.setPreowned(false);
    product.setPrice(BigDecimal.valueOf(5329.99));
    product.setReleaseDate(new Date());
    product.setShortDescription("shortDescription");
    product.setStateCondition("New");
    product.setWarranty("2 Year");
    product.setWeight("600g");
    product.setWidth("100cm");
    productService.addProduct(product);
    return product;
  }

  @ResponseBody
  @RequestMapping(value = "/rest/product/{id}", method = RequestMethod.GET)
  public Product getProduct(@PathVariable("id") int productId) {
    LOGGER.info("Start getProduct. ID=" + productId);
    return productService.getProduct(productId);
  }

  @ResponseBody
  @RequestMapping(value = "/rest/products", method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    LOGGER.info("Start getAllProducts.");
    return productService.getProducts();
  }

  @ResponseBody
  @RequestMapping(value = "/rest/product", method = RequestMethod.POST)
  public Product createProduct(@RequestBody Product product) {
    LOGGER.info("Start createProduct.");
    productService.addProduct(product);
    return product;
  }

  @ResponseBody
  @RequestMapping(value = "/rest/product/{id}", method = RequestMethod.DELETE)
  public Product deleteProduct(@PathVariable("id") int productId) {
    LOGGER.info("Start deleteProduct.");
    productService.deleteProduct(productId);
    return new Product();
  }
  
  @ResponseBody
  @RequestMapping(value = "/rest/product", method = RequestMethod.GET)
  public Product getProductByBarcode(@RequestParam(value="barcode", required=true) String barcode) {
    LOGGER.info("Start getProduct. barcode=" + barcode);
    return productService.getProductByBarcode(barcode);
  }

}
