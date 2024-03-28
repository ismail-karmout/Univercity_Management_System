package com.umi.moduleservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data

public class Role {
    private Long id;
    private String name;
    private RoleType roleType;
    private List<ProfessorRole> professorRoles;
}
