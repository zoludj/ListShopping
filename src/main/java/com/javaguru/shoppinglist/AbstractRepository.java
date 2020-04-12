package com.javaguru.shoppinglist;

import java.util.Optional;


public interface AbstractRepository {

    Optional <Product> findProductById(Long id);
    public boolean  existsByName(String name);
    public Optional<Product> findProductByName(String name);
    public Long save(Product product);
    void delete(Product product);

}
