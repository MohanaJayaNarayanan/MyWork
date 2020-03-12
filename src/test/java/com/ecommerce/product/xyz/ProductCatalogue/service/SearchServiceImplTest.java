package com.ecommerce.product.xyz.ProductCatalogue.service;

import com.ecommerce.product.xyz.exception.ProductNotFoundException;
import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.ProductRepository;
import com.ecommerce.product.xyz.repository.model.Brand;
import com.ecommerce.product.xyz.repository.model.Product;
import com.ecommerce.product.xyz.service.impl.SearchServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
public class SearchServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private SearchServiceImpl searchService;

    Product product = new Product();
    Brand brand = new Brand();
    List<Product> productList = new ArrayList<Product>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        product.setBrand(new Brand(1,"testBrandName"));
        product.setBrand(brand);
        product.setBrand_id(1);
        product.setColour("testColour");
        product.setPrice(100);
        product.setSku("testskuvalue");
        product.setProduct_name("testname");
        product.setProduct_value(12);
        product.setBrand_id(1);
    }

    @Test
    public void shouldTestGetProductBySku() throws Exception
    {
        productList.add(product);
        doReturn(productList).when(productRepository).findAll();
        Product testProduct = searchService.getProductBySku("testskuvalue");
        Assert.assertNotNull(testProduct);

    }

    @Test(expected= ProductNotFoundException.class)
    public void shouldThrowProductNotFoundException() throws Exception
    {
        productList.add(product);
        doReturn(productList).when(productRepository).findAll();
        Product testProduct = searchService.getProductBySku("failskuvalue");
        Assert.assertNotNull(testProduct);
    }

    @Test
    public void shouldGetSearchProducts() throws Exception
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setColour("testColour");
        productList.add(product);
        doReturn(productList).when(productRepository).getProductOnCriteria(searchCriteria);
        List<Product> testProducts = searchService.getSearchProducts(searchCriteria);
        Assert.assertNotNull(testProducts.size() !=0);
    }

    @Test(expected = ProductNotFoundException.class)
    public void shouldThrowProductNotException() throws Exception
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setColour("testColour");
        doReturn(null).when(productRepository).getProductOnCriteria(searchCriteria);
        List<Product> testProducts = searchService.getSearchProducts(searchCriteria);
        Assert.assertNotNull(testProducts.size() !=0);
    }



    }
