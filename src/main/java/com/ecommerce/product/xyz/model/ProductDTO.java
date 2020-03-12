package com.ecommerce.product.xyz.model;

import com.ecommerce.product.xyz.repository.model.Brand;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private int product_id;
    private String product_name;
    private String sku;
    private String colour;
    private String size;
    private String price;
    private String brand_name;
    private int brand_id;
    private int quantity;
    private int product_value;
    private int supplier_value;
    private Brand brand;
}
