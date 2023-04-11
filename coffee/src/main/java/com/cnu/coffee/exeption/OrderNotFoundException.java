package com.cnu.coffee.exeption;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String msg) {
        super(msg);
    }

    public OrderNotFoundException(RuntimeException e){
        super(e);
    }

}
