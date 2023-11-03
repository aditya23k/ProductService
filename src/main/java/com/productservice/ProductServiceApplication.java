package com.productservice;


import java.util.*;

import com.productservice.models.Category;
import com.productservice.models.Product;
import com.productservice.repository.CategoryRepository;
import com.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
        System.out.println("Hello!!");

    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setName("Apple Devices");
        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("The best iPhone Ever");
        product.setCategory(savedCategory);

        productRepository.save(product);
    }
}
