package com.example.demo.model;

import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Categories {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "categories")
    private List<Product> produtos;
}
