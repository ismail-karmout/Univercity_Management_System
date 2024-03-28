package com.umi.publication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type" , nullable = false)
    private String type;
    @Column(name = "titre" , nullable = false)
    private String titre;
    @Column(name = "auteurId" , nullable = false)
    private Long auteurId;
    @Column(name = "anneeUniversitaireId" , nullable = false)
    private Long anneeUniversitaireId;
    @Column(name = "equipeId" , nullable = false)
    private Long equipeId;
    @Column(name = "laboId" , nullable = false)
    private Long laboId;
    @Column(name = "etat" , nullable = false)
    private String etat;
    @Column(name = "justificatif" , nullable = true)
    private String justificatif;
    @CreationTimestamp
    @Column(name = "created_at" )
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at" )
    private LocalDateTime updatedAt;
    }
