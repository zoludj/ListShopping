package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.AbstractProductService;
import com.javaguru.shoppinglist.Repository;
import com.javaguru.shoppinglist.converter.ProductConverter;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
@Transactional
public class ProductController {

    private final AbstractProductService productService;


    public ProductController(AbstractProductService productService, Repository repository) {
        this.productService = productService;

    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@Validated({ProductDTO.Create.class})
                                              @RequestBody ProductDTO productDTO) throws Exception {
        productService.createProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public void updateProduct(@RequestBody ProductDTO productDTO) {
        Product product = ProductConverter.convert(productDTO);
        productService.update(product);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}



