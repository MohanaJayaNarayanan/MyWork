package com.ecommerce.product.xyz.repository;

import com.ecommerce.product.xyz.repository.model.Brand;
import com.ecommerce.product.xyz.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {


}
