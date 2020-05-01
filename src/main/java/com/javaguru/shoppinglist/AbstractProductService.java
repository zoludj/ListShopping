package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;

public interface AbstractProductService {

    public Long createProduct(ProductDTO productDTO) throws Exception;
    public ProductDTO findProductById(Long id);
    public void deleteProductById(Long id);
    void update(Product product);
}
