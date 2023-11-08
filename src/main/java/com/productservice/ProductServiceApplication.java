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

public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);

    }


}
