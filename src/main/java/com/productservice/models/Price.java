package com.productservice.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Price extends BaseModel{

    private String currency;

    private double price;
}
