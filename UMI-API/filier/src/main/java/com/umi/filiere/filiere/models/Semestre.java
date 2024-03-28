package com.umi.filiere.filiere.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Semestre {

    private Long id;

    private String name;

    private AnneeUniversitaire academicYear;

    private String session;

    private String Typesession;

    private Long idFiliere;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
