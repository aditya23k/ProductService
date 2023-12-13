package com.productservice.services;

import com.productservice.DTO.GenericProductDTO;
import com.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductServicewithUUID {

    GenericProductDTO getProductbyId(UUID id) throws NotFoundException;

    GenericProductDTO createProduct(GenericProductDTO createProduct);

    List<GenericProductDTO> getAllProducts() throws NotFoundException;

    GenericProductDTO updateProductbyId(UUID id, GenericProductDTO updateProduct) throws NotFoundException;

    GenericProductDTO deleteProductbyId(UUID id) throws NotFoundException;

    List<GenericProductDTO> getAllProductsWithCategory(UUID category_id) throws NotFoundException;
}
