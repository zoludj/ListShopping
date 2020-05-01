package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dto.ProductDTO;
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
        ProductDTO product = new ProductDTO();
        product.setName("a");
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Name will can not be less 3 words and more 32 words");
        nameValidatorRule.validate(product);
    }
    @Test
    public void success() throws Exception {
        ProductDTO product = new ProductDTO();
        product.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       nameValidatorRule.validate(product);
    }
}
