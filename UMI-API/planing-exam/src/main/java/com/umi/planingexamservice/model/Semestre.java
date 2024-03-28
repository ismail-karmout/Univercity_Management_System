package com.umi.planingexamservice.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Semestre {
    private Long id;
    private String name;
    private AnneeUniversitaire academicYear;
    private String session;
    private String typeSession;
    private Long idFiliere;
}
