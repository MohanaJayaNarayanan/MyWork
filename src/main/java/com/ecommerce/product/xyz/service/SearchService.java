package com.ecommerce.product.xyz.service;

import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {


    public void addProduct(List<Product> productz);
    public Product getProductBySku(String skuName);
    public int getCountOfSupplierProducts(int supplierName);
    public List<Product> getSearchProducts(SearchCriteria searchCriteria);
}
