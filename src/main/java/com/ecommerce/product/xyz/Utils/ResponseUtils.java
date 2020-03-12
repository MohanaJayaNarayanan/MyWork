package com.ecommerce.product.xyz.Utils;


import com.ecommerce.product.xyz.model.ErrorResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ResponseEntity<Object> createObjectResponse(Object value, HttpStatus httpStatus)
    {
        return new ResponseEntity<>(value,httpStatus);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus httpStatus, String message, String name, HttpServletRequest httpServletRequest)
    {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(),message,name,new Date(),httpServletRequest.getRequestURI());
        return new ResponseEntity<>(errorResponse,httpStatus);
    }

    public static <T> List<T> convertToDto(List<?> objectList, Class<T> tClass){
        return objectList.stream().map(item ->objectMapper.convertValue(item,tClass)).collect(Collectors.toList());
    }


}
