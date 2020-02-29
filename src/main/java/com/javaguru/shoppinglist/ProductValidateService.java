package com.javaguru.shoppinglist;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductValidateService {
    private List<ProductValidatorRule> rules;

    public ProductValidateService(List<ProductValidatorRule> rules) {
        this.rules = rules;
    }
    public void validate(Product product) throws Exception {
        for (ProductValidatorRule productValidatorRule : rules) {
            productValidatorRule.validate(product);
        }
    }
}