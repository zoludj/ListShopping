package com.javaguru.shoppinglist.validator;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class PriceValidatorRule implements ProductValidatorRule {
    public void validate(ProductDTO product) throws  Exception{
        BigDecimal price = product.getPrice();
        if (price.intValue() <0 || price.intValue() == 0) {
            throw new Exception("Price will be more 0");
        }
    }

    @Override
    public void validate(Product capture) {

    }
}



