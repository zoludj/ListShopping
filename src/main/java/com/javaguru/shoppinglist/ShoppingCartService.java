package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.converter.ShoppingCartConverter;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ShoppingCartService implements AbstractShoppingCartService {

    private final AbstractShoppingCartRepository repository;
    private final AbstractRepository productRepository;
    private final ShoppingCartConverter shoppingCartConverter;


    public ShoppingCartService(AbstractShoppingCartRepository repository, AbstractRepository productRepository, ShoppingCartConverter shoppingCartConverter) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.shoppingCartConverter = shoppingCartConverter;
    }

    public Long createOrUpdateCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart cart = shoppingCartConverter.convert(shoppingCartDTO);
        return repository.save(cart);
    }

    public ShoppingCartDTO getCartById(Long id) {
        return repository.findById(id)
                .map(shoppingCartConverter::convert)
                .orElseThrow(() -> new IllegalArgumentException("Shopping cart not found, id:" + id));
    }

    public void deleteCartById(Long id) {
        ShoppingCart shoppingCart = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Shopping cart not found, id:" + id));
        repository.delete(shoppingCart);
    }

    public BigDecimal calculateSum(long cartId) {

        ShoppingCart shoppingCart = repository.findById(cartId).orElseThrow
                (() -> new IllegalArgumentException("Shopping cart not found, id:" + cartId));
        return shoppingCart.getProducts().stream()
                .map(product -> product.getPrice().subtract(product.getDiscount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}