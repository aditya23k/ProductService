package com.productservice.services;

import com.productservice.DTO.GenericProductDTO;
import com.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDTO getProductbyId(Long id) throws NotFoundException;

    GenericProductDTO createProduct(GenericProductDTO createProduct);

    List<GenericProductDTO> getAllProducts();

    GenericProductDTO updateProductbyId(Long id);

    GenericProductDTO deleteProductbyId(Long id);
}
