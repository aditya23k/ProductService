package com.productservice.services;


import com.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{


    @Override
    public Product getProductbyId(Long id) {
        return new Product();
        //return null;
    }
}
