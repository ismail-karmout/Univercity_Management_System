package com.umi.filiere.groupesection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "schedule", nullable = true)
    private String schedule;
    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updated_at;
    @OneToOne
    private Section section;
}
