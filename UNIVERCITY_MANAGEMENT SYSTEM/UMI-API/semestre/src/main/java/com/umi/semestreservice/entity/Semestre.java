package com.umi.semestreservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semestre {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

//    @ManyToOne
//    @JoinColumn(
//            name = "academicYear",
//            nullable = false
//    )
//    private AnneeUniversitaire academicYear;
    @Column(
            name = "idAcademicYear",
            nullable = false
    )
    private Long idAcademicYear;
    @Column(
            name = "session",
            nullable = false
    )
    private String session;
    @Column(
            name = "typeSession",
            nullable = false
    )
    private String typeSession;
    @Column(
            name = "idFiliere",
            nullable = false
    )
    private Long idFiliere;



    @Column(
            name = "Date_Creation",
            columnDefinition = "TIMESTAMP",
            nullable = true,
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(
            name = "Date_Modification",
            columnDefinition = "TIMESTAMP",
            nullable = true
    )
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
