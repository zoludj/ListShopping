package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

//@Component
public class Console {
//    private ProductService productService;
//
//    public Console(ProductService productService) {
//        this.productService = productService;
//    }
//
//    public void made() {
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            try {
//                System.out.println("1. Create product");
//                System.out.println("2. Find product by id");
//                System.out.println("3. Exit");
//                Integer userInput = Integer.valueOf(scanner.nextLine());
//                switch (userInput) {
//                    case 1:
//                        createProduct(scanner);
//                        break;
//                    case 2:
//                        findProduct();
//                        break;
//                    case 3:
//                        break;
//                }
//            } catch (Exception e) {
//                System.out.println("Error! Please try again.");
//            }
//        }
//    }
//
//    private void createProduct(Scanner scanner) throws Exception {
//        System.out.println("Please, enter product name");
//        String name = scanner.nextLine();
//        System.out.println("Please, Enter product info: ");
//        String info = scanner.nextLine();
//        System.out.println("Please, enter product price");
//        BigDecimal price = scanner.nextBigDecimal();
//        System.out.println("Please, enter product discount");
//        BigDecimal discount = scanner.nextBigDecimal();
//
//        Product product = new Product();
//        product.setName(name);
//        product.setInfo(info);
//        product.setPrice(price);
//        product.setDiscount(discount);
//        productService.createProduct(product);
//        System.out.println("Created");
//    }
//
//    private void findProduct() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please, Enter product id: ");
//        Long id = scanner.nextLong();
//        Optional<Product> product = Optional.ofNullable(productService.findProductById(id));
//        System.out.println(product);
//    }
   
}
