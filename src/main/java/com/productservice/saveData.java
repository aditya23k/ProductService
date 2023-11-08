package com.productservice;

import com.productservice.models.Category;
import com.productservice.models.Price;
import com.productservice.models.Product;
import com.productservice.repository.CategoryRepository;
import com.productservice.repository.PriceRepository;
import com.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class saveData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public saveData(CategoryRepository categoryRepository, ProductRepository productRepository,
                    PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setName("Apple Devices");
        System.out.println("saving in category");
        Price price= new Price();

        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("The best iPhone Ever");
        product.setCategory(category);
        product.setPrice(price);

        productRepository.saveAndFlush(product);



        List<Product> products =  productRepository.findAllByTitle("iPhone 15 Pro");


    }
}
