package com.javaguru.shoppinglist;
import com.javaguru.shoppinglist.entity.Product;

import java.util.Optional;

 interface AbstractRepository {

    Optional <Product> findProductById(Long id);
    public boolean  existsByName(String name);
    public Optional<Product> findProductByName(String name);
    public Long save(Product product);
    public void deleteProductById(Product product);
    void delete(Product product);
}
