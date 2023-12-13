package com.productservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category extends  BaseModel {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products=new ArrayList();




}
