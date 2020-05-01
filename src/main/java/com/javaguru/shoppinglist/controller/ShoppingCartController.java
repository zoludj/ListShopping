package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.AbstractProductService;
import com.javaguru.shoppinglist.AbstractShoppingCartService;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@Transactional
public class ShoppingCartController {

    private final AbstractShoppingCartService shoppingCartService;
    private final AbstractProductService productService;


    public ShoppingCartController(AbstractShoppingCartService shoppingCartService, AbstractProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> createShoppingCart(@Validated({ShoppingCartDTO.Create.class})
                                                   @RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.createOrUpdateCart(shoppingCartDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingCartDTO> findAllCarts() {
        return shoppingCartService.findAllCarts();

    }

    @PutMapping("/{id}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProductsInCart(@PathVariable("id") Long id, @PathVariable("productId") Long productId) {
        ShoppingCartDTO dto = shoppingCartService.getCartById(id);
        dto.getProducts().add(productService.findProductById(productId));

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCartCart(@PathVariable("id") Long id, @Validated(ShoppingCartDTO.Update.class) @RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartDTO.setId(id);
        shoppingCartService.createOrUpdateCart(shoppingCartDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCartDTO getCartById(@PathVariable("id") Long id) {
        return shoppingCartService.getCartById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        shoppingCartService.deleteCartById(id);

    }


}
