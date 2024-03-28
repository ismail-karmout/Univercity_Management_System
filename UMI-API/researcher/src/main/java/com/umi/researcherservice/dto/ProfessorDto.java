package com.umi.researcherservice.dto;

import com.umi.researcherservice.entity.ProfessorRole;
import com.umi.researcherservice.entity.Researcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto extends ResearcherDto {
    private String speciality;
    private List<ProfessorRole> professorRoles;
}