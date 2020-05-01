package com.javaguru.shoppinglist;


import com.javaguru.shoppinglist.converter.ProductConverter;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements AbstractProductService {
    private final AbstractRepository repository;
    private final ProductValidateService validateService;
    private final ProductConverter productConverter;


    public ProductService(AbstractRepository repository, ProductValidateService validateService, ProductConverter productConverter, SessionFactory sessionFactory) {
        this.repository = repository;
        this.validateService = validateService;
        this.productConverter = productConverter;

    }

    public Long createProduct(ProductDTO productDTO) throws Exception {
        Product product = productConverter.convert(productDTO);
        validateService.validate(product);
        return repository.save(product);
    }

    public ProductDTO findProductById(Long id) {
        return repository.findProductById(id)
                .map(productConverter::convert)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id:" + id));
    }

    public void deleteProductById(Long id) {
        Product product = repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id:" + id));
        repository.delete(product);
    }


    public void update(Product product) {

    }

}
