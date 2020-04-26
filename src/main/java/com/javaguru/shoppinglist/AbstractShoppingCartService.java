package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.entity.ShoppingCart;

import java.math.BigDecimal;

public interface AbstractShoppingCartService {

    Long createOrUpdateCart(ShoppingCartDTO shoppingCartDTO);

    ShoppingCartDTO getCartById(Long id);

    void deleteCartById(Long id);

    BigDecimal calculateSum(long cartId);

}
