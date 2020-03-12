package com.ecommerce.product.xyz.service.impl;

import com.ecommerce.product.xyz.exception.BadRequestException;
import com.ecommerce.product.xyz.exception.ProductNotFoundException;
import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.ProductRepository;
import com.ecommerce.product.xyz.repository.model.Product;
import com.ecommerce.product.xyz.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {


    private ProductRepository productRepository;

    @Autowired
    public SearchServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     *
     * @param skuName
     * @return
     */
    @Override
    public Product getProductBySku(String skuName) {

        List<Product> products = getProducts();
        Product product = new Product();

        if(StringUtils.isEmpty(skuName))
        {
            throw new BadRequestException(" Sku number should be valid ");
        }

       Optional<Product> optionalValue = products.stream().filter(p -> p.getSku().equalsIgnoreCase(skuName)).findAny();
        if(optionalValue.isPresent()){
            product = (Product) optionalValue.get();
        }else
        {
            throw new ProductNotFoundException(" No Product found for the SKU provided ");
        }
        return product;

    }

    /**
     *
     * @param supplierId
     * @return
     */
    @Override
    public int getCountOfSupplierProducts(int supplierId) {
        return productRepository.countSupplierProducts(supplierId);
    }

    /**
     *
     * @param searchCriteria
     * @return
     */
    @Override
    public List<Product> getSearchProducts(SearchCriteria searchCriteria) {

        List<Product> productList = productRepository.getProductOnCriteria(searchCriteria);
        if(CollectionUtils.isEmpty(productList))
        {
            throw new ProductNotFoundException(" No product found for the given criteria ");
        }
        return productList;
    }

    /**
     *
     * @param products
     */
    @Override
    public void addProduct(List<Product> products) {
        products.forEach( prod -> {productRepository.save(prod);});
    }

    private List<Product> getProducts() {
      return productRepository.findAll();
    }
}
