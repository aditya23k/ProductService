package com.productservice.repository;

import com.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
    @Override
    <S extends Price> S save(S entity);

    Price findByPrice(double price);
}
