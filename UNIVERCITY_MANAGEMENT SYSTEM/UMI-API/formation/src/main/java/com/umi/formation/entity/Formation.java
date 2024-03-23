package com.umi.formation.entity;

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


public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "intitule" , nullable = false)
    private String intitule;
    @Column(name = "typeFormation" , nullable = false)
    private String typeFormation;
    @Column(name = "responsable" , nullable = false)
    private String responsable;
    @Column(name = "imageDescriptive" , nullable = true)
    @Lob
    private byte[] imageDescriptive;
    @Column(name = "documentDescriptifPath" , nullable = true)
    private String documentDescriptifPath;
    @CreationTimestamp
    @Column(name = "created_at" )
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at" )
    private LocalDateTime updatedAt;
    }
