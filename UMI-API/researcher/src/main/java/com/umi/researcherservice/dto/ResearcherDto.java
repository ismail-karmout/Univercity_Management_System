package com.umi.researcherservice.dto;

import com.umi.researcherservice.model.Labo;
import com.umi.researcherservice.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearcherDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Long laboId;
    private Labo labo;
    private Long teamId;
    private Team team;
    private Date created_at;
    private Date updated_at;


}
