package com.productservice.models;


import lombok.Builder;

@Builder
public class Product  extends BaseModel{

    private String title;

    private String description;

    private String img;

    private Category category;

    private double price;


}
