package com.javaguru.shoppinglist;

import java.util.List;
import java.util.Optional;

public interface AbstractShoppingCartRepository {
    public Long save (ShoppingCart shoppingCart);
    public Optional<ShoppingCart> findById(Long id);
    public List<ShoppingCart> findAll();
    public void delete(ShoppingCart shoppingCart);


}
