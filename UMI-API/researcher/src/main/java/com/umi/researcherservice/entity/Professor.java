package com.umi.researcherservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("professor")
//@Table(name = "professor")
public class Professor extends Researcher{
    private String speciality;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ProfessorRole> professorRoles;
}
