package com.productservice.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FakeStoreProductDTO {

    private Long id;

    private String title;

    private String description;

    private double price;

    private String category;

    private String image;
}
