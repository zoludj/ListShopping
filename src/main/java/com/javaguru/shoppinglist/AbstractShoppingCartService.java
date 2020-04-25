package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Optional;

public interface AbstractShoppingCartService {
    public Long createCart(ShoppingCart shoppingCart);
    public Optional<ShoppingCart> getCartById(Long id);
    public void deleteCartById(Long id);
    public void addProductToCar(Long cartId, Long productId);
    BigDecimal calculateSum(long cartId);

}
