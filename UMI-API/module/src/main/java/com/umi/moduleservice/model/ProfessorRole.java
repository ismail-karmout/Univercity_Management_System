package com.umi.moduleservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data

public class ProfessorRole {
    private Long id;
    private Professor professor;
    private Role role;
    private String proof;
}
