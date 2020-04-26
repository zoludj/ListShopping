package com.javaguru.shoppinglist.validator;

import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidatorRule {
    void validate(ProductDTO product) throws Exception;
}
