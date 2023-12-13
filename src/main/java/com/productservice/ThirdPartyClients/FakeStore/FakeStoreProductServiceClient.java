package com.productservice.ThirdPartyClients.FakeStore;

import com.productservice.DTO.FakeStoreProductDTO;
import com.productservice.DTO.GenericProductDTO;
import com.productservice.ThirdPartyClients.ThirdPartyProductServiceClient;
import com.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class FakeStoreProductServiceClient implements ThirdPartyProductServiceClient {


    private RestTemplateBuilder restTemplateBuilder;

    private String getProductRequestUrl= "https://fakestoreapi.com/products/{id}";

    private String createProductRequestUrl ="https://fakestoreapi.com/products";

    private String deleteProductRequestUrl= "https://fakestoreapi.com/products/{id}";

    private String getAllProductsUrl="https://fakestoreapi.com/products";

    private String updateProductUrl="https://fakestoreapi.com/products/{id}";

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;

    }

    public GenericProductDTO convertFakeStoreProductToGenericProduct(FakeStoreProductDTO fakeStoreProductDTO){

        GenericProductDTO product = new GenericProductDTO();

        product.setCategory(fakeStoreProductDTO.getCategory());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setId(fakeStoreProductDTO.getId());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setTitle(fakeStoreProductDTO.getTitle());


        return product;

    }

    @Override
    public GenericProductDTO getProductbyId(Long id) throws NotFoundException{

        RestTemplate restTemplate= restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO> responseEntity=
                restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDTO.class,id);

        FakeStoreProductDTO fakeStoreProductDTO= responseEntity.getBody();

        if(fakeStoreProductDTO==null){

            throw new NotFoundException("Product with "+id+" not found");
        }
        return convertFakeStoreProductToGenericProduct(fakeStoreProductDTO);
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
        ResponseEntity<FakeStoreProductDTO[]> listResponseEntity=
                restTemplate.getForEntity(getAllProductsUrl,FakeStoreProductDTO[].class);

        List<GenericProductDTO> listAllProducts= new ArrayList<>();

        for(FakeStoreProductDTO genericProductDTO: Arrays.stream(listResponseEntity.getBody()).toList()){
            listAllProducts.add(convertFakeStoreProductToGenericProduct(genericProductDTO));
        }
        return listAllProducts;
    }

    @Override
    public GenericProductDTO updateProductbyId(Long id,GenericProductDTO updateProduct) throws NotFoundException {

        GenericProductDTO productId= getProductbyId(id);

        productId.setImage(updateProduct.getImage());
        productId.setPrice(updateProduct.getPrice());
        productId.setTitle(updateProduct.getTitle());
        productId.setCategory(updateProduct.getCategory());
        productId.setDescription(updateProduct.getDescription());

        return productId;
    }

    @Override
    public GenericProductDTO deleteProductbyId(Long id) {

        RestTemplate restTemplate= restTemplateBuilder.build();

        RequestCallback requestCallback=
                restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor=
                restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> response=
                restTemplate
                        .execute(deleteProductRequestUrl, HttpMethod.DELETE,
                                requestCallback,responseExtractor,id);

        FakeStoreProductDTO fakeProductDTO= response.getBody();
        return convertFakeStoreProductToGenericProduct(fakeProductDTO);

    }




}
