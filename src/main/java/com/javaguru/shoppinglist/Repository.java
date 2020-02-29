package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    private Long PRODUCT_ID_SEQUENCE = 0L;
    private Map<Long, Product> products = new HashMap<>();


    public Product insert(Product product) throws Exception {
        product.setId(PRODUCT_ID_SEQUENCE);
        if (products.entrySet().stream().anyMatch(p -> p.getValue().getName().equals(product.getName()))) {
            throw new Exception("name uniqueness violation");
        }
        products.put(PRODUCT_ID_SEQUENCE, product);
        PRODUCT_ID_SEQUENCE++;
        return product;
    }

    public Product findById(Long id) {
        return products.get(id);
    }
}