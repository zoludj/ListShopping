package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

 interface AbstractShoppingCartRepository {
    Long save (ShoppingCart shoppingCart);
    Optional<ShoppingCart> findById(Long id);
     List<ShoppingCart> findAll();
     void delete(ShoppingCart shoppingCart);



}
