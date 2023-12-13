package com.productservice.services;


import com.productservice.DTO.FakeStoreProductDTO;
import com.productservice.DTO.GenericProductDTO;
import com.productservice.ThirdPartyClients.FakeStore.FakeStoreProductServiceClient;
import com.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;





    @Override
    public GenericProductDTO getProductbyId(Long id) throws NotFoundException{
        //System.out.println("Check!!");
        //FakeStoreProductService fakeStoreProductService = new FakeStoreProductService();
        return fakeStoreProductServiceClient.getProductbyId(id);
        //responseEntity.getStatusCode();
        // return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO createGenericProduct) {

        return fakeStoreProductServiceClient.createProduct(createGenericProduct);

    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return fakeStoreProductServiceClient.getAllProducts();
    }

    @Override
    public GenericProductDTO updateProductbyId(Long id, GenericProductDTO updateProduct) throws NotFoundException {
        return fakeStoreProductServiceClient.updateProductbyId(id,updateProduct);
    }

    @Override
    public GenericProductDTO deleteProductbyId(Long id) {

        return fakeStoreProductServiceClient.deleteProductbyId(id);

    }




}
