package com.javaguru.shoppinglist;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private ProductService productService;

    public Console() {
        List <ProductValidatorRule> rules = new ArrayList<>();
        rules.add(new DiscountValidatorRule());
        rules.add(new NameValidatorRule());
        rules.add(new PriceValidatorRule());
        rules.add(new ValidatorRulePriceDiscount());
        this.productService = new ProductService(new Repository(), new ProductValidateService(rules));
    }

    public void made() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, Enter product id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }

    private void createProduct() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Please, Enter product info: ");
        String info = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setInfo(info);

        productService.createProduct(product);
        System.out.println("Created");
    }
}