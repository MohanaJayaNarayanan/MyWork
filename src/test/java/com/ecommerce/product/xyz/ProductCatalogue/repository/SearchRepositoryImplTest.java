package com.ecommerce.product.xyz.ProductCatalogue.repository;

import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.impl.SearchRepositoryImpl;
import com.ecommerce.product.xyz.repository.model.Brand;
import com.ecommerce.product.xyz.repository.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;


public class SearchRepositoryImplTest {
    @Mock
    SearchRepositoryImpl searchRepository;


    final CriteriaBuilder mockCriteriaBuilder = mock(CriteriaBuilder.class);
    final CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
    final Root root = mock(Root.class);
    final Predicate predicate = mock(Predicate.class);
    final Join join = mock(Join.class);
    Query query = mock(Query.class);

    List<Product> mockProductList = new ArrayList<Product>();
    Product product;
    Brand brand;
    SearchCriteria searchCriteria = new SearchCriteria();


    @Before
    public void setUp() throws Exception {
        product = new Product();
        product.setProduct_id(1);
        product.setProduct_name("testProductName");
        MockitoAnnotations.initMocks(this);
        searchRepository =spy(SearchRepositoryImpl.class);
        searchRepository.entityManager = mock(EntityManager.class);
    }

    @Test
    public void getProductOnSearchListForBrand() throws Exception{

        mockProductList.add(product);
        searchCriteria.setBrand("testBrand");
        given(searchRepository.entityManager.getCriteriaBuilder()).willReturn(mockCriteriaBuilder);
        given(mockCriteriaBuilder.createQuery(Product.class)).willReturn(criteriaQuery);
        given(criteriaQuery.from(Product.class)).willReturn(root);
        given(root.join("brand",JoinType.INNER)).willReturn(join);

        given(criteriaQuery.where(predicate)).willReturn(criteriaQuery);
        given(query.getResultList()).willReturn(mockProductList);

        assertNotNull(searchRepository.getProductOnCriteria(searchCriteria));
    }




}
