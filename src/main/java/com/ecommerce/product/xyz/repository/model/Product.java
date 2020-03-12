package com.ecommerce.product.xyz.repository.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "PRODUCT_CATALOGUE")
@Getter@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int product_id;

    @Column
    private String product_name;

    @Column
    private String sku;

    @Column
    private String colour;

    @Column
    private String size;

    @Column
    private int brand_id;



    @Column
    private int product_value;

    @Column
    private int supplier_value;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn(updatable = false, insertable = false, name = "brand_id")
    private Brand brand;

    public Product() {
    }

    public Product(int product_id, String product_name, String sku, String colour, String size, int brand_id, int product_value, int supplier_value,int price) {
        this.product_id =product_id;
        this.product_name=product_name;
        this.sku=sku;
        this.colour=colour;
        this.size=size;
        this.brand_id=brand_id;
        this.product_value=product_value;
        this.supplier_value=supplier_value;
        this.price=price;

    }
}
