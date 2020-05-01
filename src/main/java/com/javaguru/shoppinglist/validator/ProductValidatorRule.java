package com.javaguru.shoppinglist.validator;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;

public interface ProductValidatorRule {
    void validate(ProductDTO product) throws Exception;

    void validate(Product capture);
}
