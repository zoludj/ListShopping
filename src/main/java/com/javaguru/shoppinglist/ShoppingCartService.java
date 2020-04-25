package com.javaguru.shoppinglist;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ShoppingCartService {
    private final AbstractShoppingCartRepository repository;
    private final AbstractRepository productRepository;


    public ShoppingCartService(AbstractShoppingCartRepository repository, AbstractRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    public Long createCart(ShoppingCart shoppingCart) {
        return repository.save(shoppingCart);
    }

    public ShoppingCart getCartById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Shopping cart not found, id:" + id));
    }

    public void deleteCartById(Long id) {
        ShoppingCart shoppingCart =repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Shopping cart not found, id:" + id));
        repository.delete(shoppingCart);


    }

    public ShoppingCart findById(Long cartId) {
        return repository.findById(cartId)
                .orElseThrow(() ->new IllegalArgumentException("Shopping cart not found, id:" + cartId));
    }

    BigDecimal calculateSum(long cartId){



    }

}