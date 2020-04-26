package com.javaguru.shoppinglist.converter;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.entity.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class ShoppingCartConverter {

    private ProductConverter productConverter;

    public ShoppingCartConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public ShoppingCart convert(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartDTO.getId());
        shoppingCart.setName(shoppingCartDTO.getName());
        if (shoppingCartDTO.getProducts() == null) {
            shoppingCart.setProducts(new ArrayList<>());
        } else {
            shoppingCart.setProducts(shoppingCartDTO.getProducts().stream()
                    .map(productDTO -> productConverter.convert(productDTO))
                    .collect(Collectors.toList()));

        }

        return shoppingCart;
    }

    public ShoppingCartDTO convert(ShoppingCart shoppingCart) {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setId(shoppingCart.getId());
        shoppingCartDTO.setName(shoppingCart.getName());
        shoppingCartDTO.setProducts(shoppingCart.getProducts().stream()
                .map(product -> productConverter.convert(product))
                .collect(Collectors.toList()));

        return shoppingCartDTO;
    }
}
