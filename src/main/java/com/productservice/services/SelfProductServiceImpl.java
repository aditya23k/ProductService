package com.productservice.services;

import com.productservice.DTO.GenericProductDTO;
import com.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {


    @Override
    public GenericProductDTO getProductbyId(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO createProduct){
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }
}
