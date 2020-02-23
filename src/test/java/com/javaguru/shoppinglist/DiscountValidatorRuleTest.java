package com.javaguru.shoppinglist;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountValidatorRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private DiscountValidatorRule discountValidatorRule = new DiscountValidatorRule();

    @Test
    public void anSuccess() throws Exception {
        Product product = new Product();
        product.setDiscount(new BigDecimal(-20));
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Discount will can not be less 0");
        discountValidatorRule.validate(product);

    }

    @Test
    public void Success() throws Exception {
        Product product = new Product();
        product.setDiscount(new BigDecimal(20));
        discountValidatorRule.validate(product);
    }
}