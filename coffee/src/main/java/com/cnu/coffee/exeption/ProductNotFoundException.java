package com.cnu.coffee.exeption;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String msg){
        super(msg);
    }
    public ProductNotFoundException(RuntimeException e){
        super(e);
    }
}
