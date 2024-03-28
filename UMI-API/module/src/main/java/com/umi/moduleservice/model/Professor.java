package com.umi.moduleservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Professor {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private List<ProfessorRole> professorRole;
}
