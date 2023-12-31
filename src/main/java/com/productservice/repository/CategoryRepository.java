package com.productservice.repository;

import com.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    <S extends Category> S save(S entity);

    Category findDistinctByNameEquals(String name);
}
