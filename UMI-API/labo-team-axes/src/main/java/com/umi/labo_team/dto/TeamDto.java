package com.umi.labo_team.dto;

import com.umi.labo_team.entity.Labo;
import com.umi.labo_team.entity.RechercheAxe;
import com.umi.labo_team.model.Department;
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

public class TeamDto {
    private Long id;
    private String title;
    private String slug;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
    private Labo labo;
    private List<RechercheAxe> rechercheAxes;
    private Department department;
    private Long department_id;
}
