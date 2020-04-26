package com.javaguru.shoppinglist.converter;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setInfo(product.getInfo());
        productDTO.setPrice(product.getPrice());
        productDTO.setDiscount(product.getDiscount());

        return productDTO;
    }

    public Product convert(ProductDTO productDTO) {
        Product product =new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setInfo(productDTO.getInfo());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());

        return product;
    }
}
