package com.ecommerce.product.xyz.repository;

import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository   {

    List<Product> getProductOnCriteria(SearchCriteria searchCriteria);
}
