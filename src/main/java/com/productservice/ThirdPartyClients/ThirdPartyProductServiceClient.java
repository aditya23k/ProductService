package com.productservice.ThirdPartyClients;

import com.productservice.DTO.GenericProductDTO;
import com.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyProductServiceClient {

    GenericProductDTO getProductbyId(Long id) throws NotFoundException;

    GenericProductDTO createProduct(GenericProductDTO createProduct);

    List<GenericProductDTO> getAllProducts();

    GenericProductDTO updateProductbyId(Long id, GenericProductDTO updateProduct) throws NotFoundException;

    GenericProductDTO deleteProductbyId(Long id);

}
