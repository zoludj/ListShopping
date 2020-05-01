package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AbstractShoppingCartService {

    Long createOrUpdateCart(ShoppingCartDTO shoppingCartDTO);

    ShoppingCartDTO getCartById(Long id);

    void deleteCartById(Long id);

    BigDecimal calculateSum(long cartId);

    List<ShoppingCartDTO> findAllCarts();
}
