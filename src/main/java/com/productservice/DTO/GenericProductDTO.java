package com.productservice.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class GenericProductDTO {

    private Long  id;

    private String title;

    private String description;

    private Double price;

    private String category;

    private String image;
}
