package com.cnu.coffee.exeption;

import com.cnu.coffee.product.domain.Product;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DescriptionNotFoundException extends RuntimeException{

    public DescriptionNotFoundException(String msg) {
        super(msg);
    }

    public DescriptionNotFoundException(RuntimeException e){
        super(e);
    }



}
