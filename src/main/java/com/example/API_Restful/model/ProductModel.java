package com.example.API_Restful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProductModel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Double price;

}
