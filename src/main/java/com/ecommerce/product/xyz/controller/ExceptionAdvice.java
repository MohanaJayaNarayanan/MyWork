package com.ecommerce.product.xyz.controller;

import com.ecommerce.product.xyz.Utils.ResponseUtils;
import com.ecommerce.product.xyz.exception.BadRequestException;
import com.ecommerce.product.xyz.exception.DataRetrievalException;
import com.ecommerce.product.xyz.exception.ProductNotFoundException;
import com.ecommerce.product.xyz.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ErrorResponse> noProductionFoundExceptionHandler(HttpServletRequest httpServletRequest,ProductNotFoundException ex){
        return ResponseUtils.createErrorResponse(HttpStatus.NO_CONTENT,ex.getMessage(),ex.getClass().getName(),httpServletRequest);
    }


    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorResponse> badRequestFoundExceptionHandler(HttpServletRequest httpServletRequest,BadRequestException ex){
        return ResponseUtils.createErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage(),ex.getClass().getName(),httpServletRequest);
    }

    @ExceptionHandler({DataRetrievalException.class})
    public ResponseEntity<ErrorResponse> sqlExceptionHandler(HttpServletRequest httpServletRequest,BadRequestException ex){
        return ResponseUtils.createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),ex.getClass().getName(),httpServletRequest);
    }


}
