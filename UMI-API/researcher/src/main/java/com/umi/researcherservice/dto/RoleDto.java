package com.umi.researcherservice.dto;

import com.umi.researcherservice.entity.ProfessorRole;
import com.umi.researcherservice.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    private RoleType roleType;
    private List<ProfessorRole> professorRoles;
    private Date created_at;
    private Date updated_at;
}
