package com.umi.filiere.groupesection.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umi.filiere.groupesection.model.Semestre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "section")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Section {
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
    private LocalDateTime created_at;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updated_at;
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deleted_at;
    @Column(name = "id_semestre",nullable = true)
    private Long id_semestre;
}
