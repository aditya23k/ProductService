package com.productservice.models;


import java.util.UUID;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Getter
@Setter

@MappedSuperclass
public class BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

}
