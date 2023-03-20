//package com.cnu.coffee;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ProductRepositoryImpl implements ProductRepository {
//
//    private final Map<Integer, Product> db = new HashMap<>();
//    int idx = 0;
//
//    @Override
//    public Product save(Product product) {
//        db.put(idx++, product);
//        return product;
//    }
//}
