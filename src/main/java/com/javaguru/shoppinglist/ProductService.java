package com.javaguru.shoppinglist;

public class ProductService {
    private Repository repository;
    private ProductValidateService service;

    public ProductService(Repository repository, ProductValidateService service) {
        this.repository = repository;
        this.service = service;
    }

    public Long createProduct(Product product) throws Exception {
        service.validate(product);
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return null;
    }
}
