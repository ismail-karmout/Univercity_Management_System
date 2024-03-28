package com.umi.labo_team.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "recherche_axes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RechercheAxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "slug", nullable = false)
    private String slug;
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;
}
