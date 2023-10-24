package com.productservice.services;

import com.productservice.DTO.GenericProductDTO;
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

    @Override
    public GenericProductDTO updateProductbyId(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO deleteProductbyId(Long id) {
        return null;
    }
}
