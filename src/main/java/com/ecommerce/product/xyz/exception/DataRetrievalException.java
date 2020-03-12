package com.ecommerce.product.xyz.exception;

public class DataRetrievalException extends RuntimeException {

    public DataRetrievalException(String msg)
    {
        super(msg);
    }

    public DataRetrievalException(String errorMsg, Throwable e)
    {
        super(errorMsg,e);
    }


}
