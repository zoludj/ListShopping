package com.javaguru.shoppinglist.validator;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class NameValidatorRule implements ProductValidatorRule {
    public void validate(ProductDTO product) throws Exception {
        String name = product.getName();
        if (name.length() < 3 || name.length() > 32) {
            throw new Exception("Name will can not be less 3 words and more 32 words");
        }
    }
}
