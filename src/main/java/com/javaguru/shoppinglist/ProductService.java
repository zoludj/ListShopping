package com.javaguru.shoppinglist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    private final AbstractRepository repository;
    private final ProductValidateService validateService;
@Autowired
    public ProductService(AbstractRepository repository, ProductValidateService validateService) {
        this.repository = repository;
        this.validateService = validateService;
    }


    public Long createProduct(Product product) throws Exception {
        validateService.validate(product);
        Long createdProduct = repository.save(product);
        return createdProduct;
    }

    Optional<Product> findProductById(Long id) {
        return repository.findProductById(id);
    }


}
