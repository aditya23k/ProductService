package com.productservice.services;

import java.util.*;
import com.productservice.DTO.GenericProductDTO;
import com.productservice.models.Product;

public interface ProductService {

    GenericProductDTO getProductbyId(Long id);

    GenericProductDTO createProduct(GenericProductDTO createProduct);

    List<GenericProductDTO> getAllProducts();





}
