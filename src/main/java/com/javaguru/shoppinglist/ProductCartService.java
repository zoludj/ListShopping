package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCartService implements AbstractProductCartService {

    private final ProductService productService;
    private  final  ShoppingCartService shoppingCartService;

    public ProductCartService(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @Transactional
    public void addProductToCart(Long productId, Long cartId){
        ProductDTO productDTO = productService.findProductById(productId);
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getCartById(cartId);
        shoppingCartDTO.getProducts().add(productDTO);
        shoppingCartService.createOrUpdateCart(shoppingCartDTO);
    }

}
