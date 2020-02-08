package com.javaguru.shoppinglist;

public class Repository {

    public class ProductService {
        private Repository repository = new Repository();
        private ProductValidateService service = new ProductValidateService();

        public Long createProduct(Product product) {
            service.validate(product);
            Product createdProduct = repository.insert(product);
            return createdProduct.getId();
        }

    }

    Product insert(Product product) {
        return product;
    }
}