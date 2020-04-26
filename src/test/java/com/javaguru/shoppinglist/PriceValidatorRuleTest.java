package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.entity.Product;
import com.javaguru.shoppinglist.validator.PriceValidatorRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

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