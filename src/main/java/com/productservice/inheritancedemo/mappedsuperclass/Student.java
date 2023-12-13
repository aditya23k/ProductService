package com.productservice.inheritancedemo.mappedsuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_student")

public class Student extends User {

    private double attendance;
    private double PSP;
}
