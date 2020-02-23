package com.javaguru.shoppinglist;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PriceValidatorRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private PriceValidatorRule priceValidatorRule = new PriceValidatorRule();

    @Test
    public void anSuccess() throws Exception {
        Product product = new Product();
        product.setPrice(new BigDecimal(-10));
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Price will be more 0");
        priceValidatorRule.validate(product);
    }

    @Test
    public void success() throws Exception {
        Product product = new Product();
        product.setPrice(new BigDecimal(10));
        priceValidatorRule.validate(product);
    }
}