package com.javaguru.shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private AbstractRepository repository;
    private ProductValidateService service;

    public ProductService(AbstractRepository repository, ProductValidateService service) {
        this.repository = repository;
        this.service = service;
}



    public Long createProduct(Product product) throws Exception {
        service.validate(product);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();
    }

        Optional<Product> findProductById(Long id) {
            return repository.findProductById(id);
        }
    }

