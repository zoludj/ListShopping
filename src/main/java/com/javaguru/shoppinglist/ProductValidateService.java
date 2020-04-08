package com.javaguru.shoppinglist;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidateService {
    private List<ProductValidatorRule> rules;

    public ProductValidateService(List<ProductValidatorRule> rules) {
        this.rules = new ArrayList<>();
        this.rules.add(new DiscountValidatorRule());
        this.rules.add(new NameValidatorRule());
        this.rules.add(new PriceValidatorRule());
        this.rules.add(new ValidatorRulePriceDiscount());

    }


    public void validate(Product product) throws Exception {
        for (ProductValidatorRule productValidatorRule : rules) {
            productValidatorRule.validate(product);
        }
    }
}