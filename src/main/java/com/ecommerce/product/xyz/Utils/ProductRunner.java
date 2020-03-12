package com.ecommerce.product.xyz.Utils;

import com.ecommerce.product.xyz.repository.BrandRepository;
import com.ecommerce.product.xyz.repository.model.Brand;
import com.ecommerce.product.xyz.repository.model.Product;
import com.ecommerce.product.xyz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void run(String... args) throws Exception {

        brandRepository.save(new Brand(1,"Lp"));
        brandRepository.save(new Brand(2,"PeterEngland"));
        brandRepository.save(new Brand(3,"Basics"));
        brandRepository.save(new Brand(4,"Wrangler"));
        brandRepository.save(new Brand(5,"Max"));


        productRepository.save(new Product(6,"name1","sku000x1","White","M",2,5,4,1000));
        productRepository.save(new Product(7,"name2","sku000x2","Blue","L",2,3,4,1500));
        productRepository.save(new Product(8,"name3","sku000x3","Orange","XS",3,2,5,1200));
        productRepository.save(new Product(9,"name4","sku000x4","White","S",4,1,1,500));
        productRepository.save(new Product(10,"name5","sku000x5","Black","M",5,5,2,2500));
        productRepository.save(new Product(11,"name6","sku000x6","Yellow","L",5,3,3,200));
        productRepository.save(new Product(12,"name7","sku000x7","white","XL",4,3,5,150));
        productRepository.save(new Product(13,"name8","sku000x8","Red","XXL",3,2,2,2500));
        productRepository.save(new Product(14,"name9","sku000x9","Green","S",3,1,1,3000));
        productRepository.save(new Product(15,"name10","sku000x10","Red","M",1,3,4,400));
        productRepository.save(new Product(16,"name11","sku000x11","White","M",2,5,4,1000));
        productRepository.save(new Product(17,"name12","sku000x12","Blue","L",2,3,2,1500));
        productRepository.save(new Product(18,"name13","sku000x13","Red","XS",2,2,3,1200));
        productRepository.save(new Product(19,"name14","sku000x14","White","L",4,1,1,500));
        productRepository.save(new Product(20,"name15","sku000x15","Black","M",5,6,2,2000));
        productRepository.save(new Product(21,"name16","sku000x16","Yellow","L",3,3,3,200));
        productRepository.save(new Product(22,"name17","sku000x17","Black","XL",5,1,4,5000));
        productRepository.save(new Product(23,"name18","sku000x18","Red","XXL",2,1,4,2500));
        productRepository.save(new Product(24,"name19","sku000x19","Green","XXL",3,3,2,3000));
        productRepository.save(new Product(25,"name20","sku000x20","Red","xl",1,3,1,400));



    }
}
