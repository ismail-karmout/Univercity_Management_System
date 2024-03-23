package com.umi.filiere.filiere.models;


import lombok.Data;

@Data
public class Department {
    private Long id;
    private String name;
    private String description;
    private String slug;
}