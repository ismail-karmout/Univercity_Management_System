package com.umi.researcherservice.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class Labo {
    private Long id;
    private String acroname;
    private String title;
    private String slug;
    private Long department_id;
}
