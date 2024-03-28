package com.umi.recherche.ecoledoctorale.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ecoledoctorale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EcoleDoctorale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description" , nullable = false)
    private String description;
    @Column(name = "slug", nullable = false)
    private String slug;
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;
}
