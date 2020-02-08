package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class DiscountValidatorRule implements ProductValidatorRule{
    public void validate (Product product) throws Exception {
        BigDecimal discount = product.getDiscount();
        if (discount.intValue() < 0 || discount.intValue() >100){
            throw new Exception("Discount will can not be less 0  and more 100");
        }
    }
}
