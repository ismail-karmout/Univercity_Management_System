package com.umi.moduleservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Semestre {
    private Long id;
    private String name;
    private AnneeUniversitaire academicYear;
    private String session;
    private String typeSession;
    private Long idFiliere;
}
