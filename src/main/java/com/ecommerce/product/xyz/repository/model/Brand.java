package com.ecommerce.product.xyz.repository.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "PRODUCT_CATALOGUE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int brand_id;

    @Column
    private String brand_name;


}
