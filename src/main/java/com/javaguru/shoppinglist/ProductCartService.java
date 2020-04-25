package com.javaguru.shoppinglist;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCartService {

    private final ProductService productService;
    private  final  ShoppingCartService shoppingCartService;

    public ProductCartService(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }
    @Transactional
    public void addProductToCart(Long productId, Long cartId){
        Product product = productService.findProductById(productId);
        ShoppingCart shoppingCart = shoppingCartService.findById(cartId);
    }

}
