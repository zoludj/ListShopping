
package com.javaguru.shoppinglist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidateServiceTest {

    @Mock
    private NameValidatorRule nameValidatorRule;
    @Captor
    private ArgumentCaptor<Product> captor;
    private ProductValidateService victim;
    private Product product = createProduct();
    @Before
    public void setUp() {

        List<ProductValidatorRule> rules = new ArrayList<>();
        rules.add(nameValidatorRule);
        victim = new ProductValidateService(rules);
    }

    @Test
    public void shouldValidate() throws Exception {

        victim.validate(product);
        verify(nameValidatorRule).validate(captor.capture());
        List<Product> resultList = captor.getAllValues();
        assertThat(resultList).containsOnly(product);
    }
    private Product createProduct(){
        Product product = new Product();
        product.setId(100L);
        product.setInfo("TEST_INFO");
        product.setName("TEST_NAME");
        return product;

    }
}

