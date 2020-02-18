package com.javaguru.shoppinglist;

public class ProductService {
    private Repository repository = new Repository();
    private ProductValidateService service = new ProductValidateService();

    public Long createProduct(Product product) throws Exception {
        service.validate(product);
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return null;
    }
}
