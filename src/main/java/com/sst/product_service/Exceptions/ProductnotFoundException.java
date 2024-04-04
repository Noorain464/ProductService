package com.sst.product_service.Exceptions;

public class ProductnotFoundException extends RuntimeException{
    public Long id;
    public ProductnotFoundException(Long id,String message){
        super(message);
        this.id = id;
    }

}
