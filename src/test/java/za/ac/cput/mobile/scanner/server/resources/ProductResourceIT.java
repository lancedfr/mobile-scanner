package za.ac.cput.mobile.scanner.server.resources;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import za.ac.cput.mobile.scanner.repository.model.Product;
import za.ac.cput.mobile.scanner.service.product.ProductService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:root-context-test.xml", "classpath:servlet-context-test.xml" })
public class ProductResourceIT {
  
  private MockMvc mockMvc;

  @Mock
  private ProductService productService;
  
  @InjectMocks
  private ProductResource productResource;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
  }

  @Test
  public void getAllProducts() throws Exception {
    Product product1 = new Product();
    product1.setBarcode("43214321");
    product1.setName("Lance");

    Product product2 = new Product();
    product2.setBarcode("1234123123");
    product2.setName("Reid");

    when(productService.getProducts()).thenReturn(Arrays.asList(product1, product2));

    mockMvc.perform(get(ProductRestURIConstants.GET_ALL_PRODUCT)).andExpect(status().isOk());
    // mockMvc
    // .perform(get(ProductRestURIConstants.GET_ALL_PRODUCT))
    // .andExpect(status().isOk())
    // .andExpect(view().name("todo/list"))
    // .andExpect(forwardedUrl("/WEB-INF/jsp/todo/list.jsp"))
    // .andExpect(model().attribute("todos", hasSize(2)))
    // .andExpect(
    // model().attribute(
    // "todos",
    // hasItem(allOf(hasProperty("id", is(1L)), hasProperty("description",
    // is("Lorem ipsum")),
    // hasProperty("title", is("Foo"))))))
    // .andExpect(
    // model().attribute(
    // "todos",
    // hasItem(allOf(hasProperty("id", is(2L)), hasProperty("description",
    // is("Lorem ipsum")),
    // hasProperty("title", is("Bar"))))));

    verify(productService, times(1)).getProducts();
    verifyNoMoreInteractions(productService);
  }
}