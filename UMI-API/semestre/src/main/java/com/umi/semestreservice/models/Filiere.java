package com.umi.semestreservice.models;

import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Filiere {

    private Long id;
    private String name;
    private int nbAnnees;
    private int nbSemestres;
    private String responsable;
    private String anneeDiplomante;
    private String anneesNonDiplomantes;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
   }


