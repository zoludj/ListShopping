package com.javaguru.shoppinglist.validator;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class ValidatorRulePriceDiscount implements ProductValidatorRule {
    public void validate(ProductDTO product) throws Exception {
        BigDecimal price = product.getPrice();
        BigDecimal discount = product.getDiscount();
        if (price.intValue() < 20 && discount.intValue() > 0) {
            throw new Exception("If price less then 20, discount not apply");
        }
    }
}
