package com.productservice.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseModel{

    private String title;

    private String description;

    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Price price;


}
