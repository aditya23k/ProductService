package com.productservice.controller;

import com.productservice.DTO.GenericProductDTO;
import com.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @PostMapping()
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO createGenericProduct){
        //System.out.println(createProduct.);
        return productService.createProduct(createGenericProduct);

    }
    @GetMapping()
    public void getAllProducts(){



    }

    @GetMapping("/{id}")
    public GenericProductDTO getProductbyId(@PathVariable("id") Long id){

        return productService.getProductbyId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductbyId(@PathVariable("id") Long id){


    }

    @PutMapping("/{id}")
    public void updateProductbyId(@PathVariable("id") Long id){


    }
}
