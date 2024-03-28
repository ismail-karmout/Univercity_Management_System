package com.umi.moduleservice.model;

import lombok.Data;

import java.util.List;

@Data
public class AnneeUniversitaire {
    private Long id;
    private Boolean courante;
    private Integer startYear;
    private Integer endYear;
    private List<Semestre> semestres;
}
