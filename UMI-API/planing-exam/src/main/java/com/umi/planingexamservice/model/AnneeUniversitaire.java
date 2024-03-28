package com.umi.planingexamservice.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
@Data
public class AnneeUniversitaire {
    private Long id;
    private Boolean courante;
    private Integer startYear;
    private Integer endYear;
    private List<Semestre> semestres;
}
