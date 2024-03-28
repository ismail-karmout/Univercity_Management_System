package com.umi.researcherservice.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class Team {
    private Long id;
    private String title;
    private String slug;
}
