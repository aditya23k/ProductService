package com.productservice.repository;

import com.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository1 extends JpaRepository<Product, UUID> {
}