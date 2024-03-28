package com.umi.labo_team.dto;

import com.umi.labo_team.entity.RechercheAxe;
import com.umi.labo_team.entity.Team;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.model.EcoleDoctorale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class LaboDto {
    private Long id;
    private String acroname;
    private String title;
    private String slug;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
    private List<Team> teams;
    private List<RechercheAxe> rechercheAxes;
    private Long department_id;
    private Department department;
    private Long ecole_doctorale_id;
    private EcoleDoctorale ecoleDoctorale;
}