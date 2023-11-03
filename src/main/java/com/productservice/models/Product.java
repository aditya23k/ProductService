package com.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseModel{

    private String title;

    private String description;

    private String image;

    @ManyToOne
    private Category category;

    private double price;


}
