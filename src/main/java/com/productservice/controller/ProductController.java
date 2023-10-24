package com.productservice.controller;

import com.productservice.DTO.ExceptionDTO;
import com.productservice.DTO.GenericProductDTO;
import com.productservice.exceptions.NotFoundException;
import com.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GenericProductDTO> getAllProducts(){
        return productService.getAllProducts();

    }

    @GetMapping("/{id}")
    public GenericProductDTO getProductbyId(@PathVariable("id") Long id) throws NotFoundException {

        return productService.getProductbyId(id);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDTO> deleteProductbyId(@PathVariable("id") Long id){

        return new ResponseEntity<>
                (productService.deleteProductbyId(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public GenericProductDTO updateProductbyId(@PathVariable("id") Long id){

        return productService.updateProductbyId(id);
    }
}
