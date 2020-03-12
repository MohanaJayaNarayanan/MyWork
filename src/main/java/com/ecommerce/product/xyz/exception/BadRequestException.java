package com.ecommerce.product.xyz.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg)
    {
        super(msg);
    }

    public BadRequestException(String errorMsg,Throwable e)
    {
        super(errorMsg,e);
    }


}
