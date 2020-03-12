package com.ecommerce.product.xyz.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchCriteria {

    private String brand;
    private String colour;
    private String size;
    private int price;
}
