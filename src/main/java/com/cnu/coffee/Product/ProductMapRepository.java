package com.cnu.coffee.Product;

import com.cnu.coffee.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductMapRepository implements ProductRepository {

    Map<String, Integer> db = new HashMap<String, Integer>();

    @Override
    public String save(Product product) {
        System.out.println(product.getName());
        db.put(product.getName(), product.getPrice());
        return db.toString();
    }
}
