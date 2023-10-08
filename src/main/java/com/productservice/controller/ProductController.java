package com.productservice.controller;

import com.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @PostMapping()
    public void createProduct(){

    }
    @GetMapping()
    public void getAllProducts(){

    }
    @GetMapping("{id}")
    public String getProductbyId(@PathVariable("id") Long id){
        return "Here is the product with id "+id;
    }
    @DeleteMapping("{id}")
    public void deleteProductbyId(@PathVariable("id") Long id){

    }
    @PutMapping("{id}")
    public void updateProductbyId(@PathVariable("id") Long id){


    }
}
