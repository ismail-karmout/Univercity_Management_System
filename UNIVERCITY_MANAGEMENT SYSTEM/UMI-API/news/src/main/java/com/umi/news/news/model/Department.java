package com.umi.news.news.model;

import lombok.Data;

@Data
public class Department {
    private Long id;
    private String name;
    private String description;
    private String slug;
}