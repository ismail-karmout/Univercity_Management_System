package com.umi.filiere.filiere.dto;

import com.umi.filiere.filiere.models.Department;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereDto {
    private Long id;
    private String name;
    private int nbAnnees;
    private int nbSemestres;
    private String responsable;
    private String anneeDiplomante;
    private String anneesNonDipolomantes;
    private String slug;
    private List<Long> listeSemestres;
    private Long department_id;
    private Department department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public String getAnneesNonDiplomantes() {
        return  anneesNonDipolomantes;
    }
}
