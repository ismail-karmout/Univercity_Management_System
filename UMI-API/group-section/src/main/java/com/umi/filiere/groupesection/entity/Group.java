package com.umi.filiere.groupesection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "groupe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Group {
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
    private LocalDateTime deletedAt;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}
