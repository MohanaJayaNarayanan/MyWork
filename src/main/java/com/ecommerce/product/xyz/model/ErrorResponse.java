package com.ecommerce.product.xyz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ErrorResponse {

    private int status;
    private String message;
    private String classname;
    private Date timeStamp;
    private String path;
}
