package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class PriceValidatorRule implements ProductValidatorRule {
    public void validate(Product product) throws  Exception{
        BigDecimal price = product.getPrice();
        if (price.compareTo(price)<0 || price.compareTo(price) == 0) {
            throw new Exception("Price will be more 0");
        }
    }
}



