package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ValidatorRulePriceDiscount implements ProductValidatorRule {
    public void validate(Product product) throws Exception {
        BigDecimal price = product.getPrice();
        BigDecimal discount = product.getDiscount();
        if (price.compareTo(price) < 20 && discount.compareTo(discount) != 0);{
            throw new Exception("If price less then 20, discount not apply");
        }
    }
}
