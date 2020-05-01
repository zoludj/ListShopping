package com.javaguru.shoppinglist.validator;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class DiscountValidatorRule implements ProductValidatorRule{
    public void validate (ProductDTO product) throws Exception {
        BigDecimal discount = product.getDiscount();
        if (discount.intValue() < 0 || discount.intValue() >100){
            throw new Exception("Discount will can not be less 0  and more 100");
        }
    }

    @Override
    public void validate(Product capture) {

    }
}
