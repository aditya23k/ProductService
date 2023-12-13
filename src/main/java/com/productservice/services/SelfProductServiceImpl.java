package com.productservice.services;

import com.productservice.DTO.GenericProductDTO;
import com.productservice.exceptions.NotFoundException;
import com.productservice.models.Category;
import com.productservice.repository.ProductRepository;
import com.productservice.repository.CategoryRepository;
import com.productservice.repository.PriceRepository;
import org.springframework.stereotype.Service;
import com.productservice.models.Product;
import com.productservice.models.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductServicewithUUID {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;

    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    public GenericProductDTO convertProductToGenericProductDTO(Product product) {

        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setImage(product.getImage());
        genericProductDTO.setDescription(product.getDescription());
        genericProductDTO.setTitle(product.getTitle());
        genericProductDTO.setPrice(product.getPrice().getPrice());
        genericProductDTO.setCategory(product.getCategory().getName());
        return genericProductDTO;
    }


    @Override
    public GenericProductDTO getProductbyId(UUID id) throws NotFoundException{
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        return convertProductToGenericProductDTO(product);
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO createProduct){
        Product product = new Product();
        product.setTitle(createProduct.getTitle());
        product.setDescription(createProduct.getDescription());
        product.setImage(createProduct.getImage());
        Category setCag= new Category();
        if(categoryRepository.findDistinctByNameEquals(createProduct.getCategory())==null){
            setCag.setName(createProduct.getCategory());
            categoryRepository.save(setCag);
        }
        else{
            setCag=categoryRepository.findDistinctByNameEquals(createProduct.getCategory());
        }
        product.setCategory(setCag);
        Price priceSet= new Price();
        if(priceRepository.findByPrice(createProduct.getPrice())==null){
            priceSet.setPrice(createProduct.getPrice());
            priceSet.setCurrency("Rupees");
            priceRepository.save(priceSet);
        }
        else{
            priceSet=priceRepository.findByPrice(createProduct.getPrice());
        }
        product.setPrice(priceSet);
        productRepository.save(product);
        return convertProductToGenericProductDTO(product);

    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<Product> list_products= productRepository.findAll();
        List<GenericProductDTO> list_generic_products= new ArrayList<>();
        for(Product product: list_products){
            list_generic_products.add(convertProductToGenericProductDTO(product));
        }
        return list_generic_products;
    }

    @Override
    public GenericProductDTO updateProductbyId(UUID id, GenericProductDTO updateProduct) throws NotFoundException {
        Product product= productRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Product not found"));
        product.setTitle(updateProduct.getTitle());
        product.setDescription(updateProduct.getDescription());
        product.setImage(updateProduct.getImage());
        Category setCag= new Category();
        if(categoryRepository.findDistinctByNameEquals(updateProduct.getCategory())==null){
            setCag.setName(updateProduct.getCategory());
            categoryRepository.save(setCag);
        }
        else{
            setCag=categoryRepository.findDistinctByNameEquals(updateProduct.getCategory());
        }
        product.setCategory(setCag);
        Price priceSet= new Price();
        if(priceRepository.findByPrice(updateProduct.getPrice())==null){
            priceSet.setPrice(updateProduct.getPrice());
            priceSet.setCurrency("Rupees");
            priceRepository.save(priceSet);
        }
        else{
            priceSet=priceRepository.findByPrice(updateProduct.getPrice());
        }
        product.setPrice(priceSet);
        productRepository.save(product);
        return convertProductToGenericProductDTO(product);
    }

    @Override
    public GenericProductDTO deleteProductbyId(UUID id) throws NotFoundException {
        Product product= productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        productRepository.delete(product);
        return convertProductToGenericProductDTO(product);

    }

    @Override
    public List<GenericProductDTO> getAllProductsWithCategory(UUID category_id) throws NotFoundException {
        if(categoryRepository.findById(category_id).isEmpty()){
            throw new NotFoundException("Category not found");
        }
        else{
            Category category= categoryRepository.findById(category_id).get();
            List<Product> list_products= productRepository.findAllByCategory(category);
            List<GenericProductDTO> list_generic_products= new ArrayList<>();
            for(Product product: list_products){
                list_generic_products.add(convertProductToGenericProductDTO(product));
            }
            return list_generic_products;
        }
    }
}
