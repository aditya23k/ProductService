package com.productservice.services;


import com.productservice.DTO.FakeStoreProductDTO;
import com.productservice.DTO.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductRequestUrl= "https://fakestoreapi.com/products/{id}";

    private String createProductRequestUrl ="https://fakestoreapi.com/products";

    private String deleteProductRequestUrl= "https://fakestoreapi.com/products/{id}";

    private String getAllProductsUrl="https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;

    }

    @Override
    public GenericProductDTO getProductbyId(Long id) {
        //System.out.println("Check!!");
        //FakeStoreProductService fakeStoreProductService = new FakeStoreProductService();
        RestTemplate restTemplate= restTemplateBuilder.build();


        ResponseEntity<FakeStoreProductDTO> responseEntity=
                restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDTO.class,id);

        FakeStoreProductDTO fakeStoreProductDTO= responseEntity.getBody();

        GenericProductDTO product= new GenericProductDTO();

        product.setCategory(fakeStoreProductDTO.getCategory());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setId(fakeStoreProductDTO.getId());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setTitle(fakeStoreProductDTO.getTitle());

        return product;
        //responseEntity.getStatusCode();
        // return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO createGenericProduct) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> responseEntity
                = restTemplate.postForEntity(createProductRequestUrl,createGenericProduct,GenericProductDTO.class);

        return responseEntity.getBody();

    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO[]> listResponseEntity=
                restTemplate.getForEntity(getAllProductsUrl,GenericProductDTO[].class);

        List<GenericProductDTO> listAllProducts= new ArrayList<>();

        for(GenericProductDTO genericProductDTO: Arrays.stream(listResponseEntity.getBody()).toList()){
            GenericProductDTO product= new GenericProductDTO();
            product.setPrice(genericProductDTO.getPrice());
            product.setTitle(genericProductDTO.getTitle());
            product.setImage(genericProductDTO.getImage());
            product.setId(genericProductDTO.getId());
            product.setCategory(genericProductDTO.getCategory());
            product.setDescription(genericProductDTO.getDescription());

            listAllProducts.add(product);
        }
        return listAllProducts;
    }

    @Override
    public GenericProductDTO deleteProductbyId(Long id) {

        GenericProductDTO deleteProduct;


        return null;
    }


}
