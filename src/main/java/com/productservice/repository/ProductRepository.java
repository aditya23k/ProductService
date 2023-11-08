package com.productservice.repository;

import ch.qos.logback.core.boolex.EvaluationException;
import com.productservice.models.Category;
import com.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository <Product, UUID> {

    @Override
    <S extends Product> S save(S entity);

    //Product findProductbyTitleAndPrice(String title, String price);



    @Query(value="select * from product where title= :title", nativeQuery = true)
    List<Product> findAllByTitle(String title);


    List<Product> findAllByCategory(Category category);
}
