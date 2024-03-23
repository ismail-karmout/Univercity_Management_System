package com.umi.filiere.filiere.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umi.filiere.filiere.models.Department;
import com.umi.filiere.filiere.models.Semestre;
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
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "nbAnnees" , nullable = false)
    private int nbAnnees;

    @Column(name = "nbSemestres" , nullable = false)
    private int nbSemestres;

    @Column(name = "responsable" , nullable = false)
    private String responsable;

    @Column(name = "anneeDiplomante" , nullable = true)
    private String anneeDiplomante;

    @Column(name = "anneesNonDiplomantes" , nullable = true)
    private String anneesNonDiplomantes;

    @Column(name = "slug" , nullable = true)
    private String slug;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ElementCollection
    @CollectionTable(name = "filiere-semestres",joinColumns
     = @JoinColumn(name = "filiere_id"))
      @Column(name = "semestre_id")
      private List<Long> listeSemestres;

    @JoinColumn(name = "department_id")
    @Column(name="department_id")
    private Long department_id ;
    @Transient
    private Department department;

    @CreationTimestamp
    @Column(name = "createdAt" )
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt" )
    private LocalDateTime updatedAt;
   }


