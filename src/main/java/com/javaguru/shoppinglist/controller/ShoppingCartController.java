package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.AbstractProductCartService;
import com.javaguru.shoppinglist.AbstractShoppingCartService;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class ShoppingCartController {

    private final AbstractShoppingCartService shoppingCartService;
    private final AbstractProductCartService productCartService;

    public ShoppingCartController(AbstractShoppingCartService shoppingCartService, AbstractProductCartService productCartService) {
        this.shoppingCartService = shoppingCartService;
        this.productCartService = productCartService;
    }

    @PostMapping
    public ResponseEntity<Void> createShoppingCart(@Validated({ShoppingCartDTO.Create.class})
                                                       @RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.createOrUpdateCart(shoppingCartDTO);
        return ResponseEntity.ok().build();
    }
}
