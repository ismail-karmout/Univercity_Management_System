package com.umi.filiere.filiere.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AnneeUniversitaire {

    private Long id;

    private Boolean courante;

    private Integer startYear;

    private Integer endYear;

    private List<Semestre> semestres;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
