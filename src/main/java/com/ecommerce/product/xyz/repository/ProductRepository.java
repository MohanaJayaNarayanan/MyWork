package com.ecommerce.product.xyz.repository;

import com.ecommerce.product.xyz.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>,SearchRepository {


    @Query(value = "select  count(a.product_id) from PRODUCT_CATALOGUE.Product a left outer join PRODUCT_CATALOGUE.Supplier b on a.supplier_value = b.supplier_Id where  b.supplier_id = :supplierId group by b.supplier_name",nativeQuery = true)
    public int countSupplierProducts(int supplierId);


}
