package com.productservice.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Builder
public class FakeStoreProductDTO {

    private Long id;

    private String title;

    private String description;

    private Double price;

    private String category;

    private String image;
}
