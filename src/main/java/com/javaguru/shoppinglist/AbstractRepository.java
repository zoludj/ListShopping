package com.javaguru.shoppinglist;

import java.util.Optional;


public interface AbstractRepository {

    Optional <Product> findProductById(Long id);
    public boolean existsByName(String name);
    public Optional<Product> findProductName(String name);
    public Product save(Product product);


}
