package com.javaguru.shoppinglist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() ->new IllegalArgumentException("Product not found, id:" +id));
    }

    public void deleteProductById(Long id) {
      Product product =  repository.findProductById(id)
                .orElseThrow(() ->new IllegalArgumentException("Product not found, id:" +id));
repository.delete(product);
    }
}
