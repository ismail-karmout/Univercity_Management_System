package com.umi.semestreservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnneeUniversitaire {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;
    @Column(
            name = "Designation_Courante",
            nullable = false
    )
    private Boolean courante;
    @Column(
            name = "startYear",
            nullable = false
    )
    private Integer startYear;
    @Column(
            name = "endYear",
            nullable = false
    )
    private Integer endYear;
//    @OneToMany(
//            mappedBy = "academicYear",
//            cascade = {CascadeType.ALL}
//    )
//    private List<Semestre> semestres;

    @CreationTimestamp
    @Column(
            name = "Date_Creation"
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(
            name = "Date_Modification"
    )
    private LocalDateTime updatedAt;
}
