package com.ecommerce.product.xyz.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String msg)
    {
        super(msg);
    }

    public ProductNotFoundException(String errorMsg, Throwable e)
    {
        super(errorMsg,e);
    }


}
