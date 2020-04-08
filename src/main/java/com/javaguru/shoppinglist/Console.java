package com.javaguru.shoppinglist;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Console {
    private ProductService productService;

    public Console(ProductService productService) {
        this.productService = productService;
    }


    public void made() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        createProduct();
                        break;
                    case "2":
                        findProduct();
                        break;
                    case "3":
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, Enter product id: ");
        Long id = scanner.nextLong();
        Optional<Product> product = productService.findProductById(id);
        System.out.println(product);
    }

    private void createProduct() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Please, Enter product info: ");
        String info = scanner.nextLine();
        System.out.println("Please, enter product price");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.println("Please, enter product discount");
        BigDecimal discount = scanner.nextBigDecimal();

        Product product = new Product();
        product.setName(name);
        product.setInfo(info);
        product.setPrice(price);
        product.setDiscount(discount);
        productService.createProduct(product);
        System.out.println("Created");
    }
}