package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.entity.Product;
import com.javaguru.shoppinglist.validator.NameValidatorRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NameValidatorRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private NameValidatorRule nameValidatorRule = new NameValidatorRule();
    private Product input;

    public NameValidatorRuleTest(Product input) {
        this.input = input;
    }

    @Test
    public void anSuccess() throws Exception {
        Product product = new Product();
        product.setName("a");
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Name will can not be less 3 words and more 32 words");
        nameValidatorRule.validate(product);
    }
    @Test
    public void success() throws Exception {
        Product product = new Product();
        product.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       nameValidatorRule.validate(product);
    }
}
