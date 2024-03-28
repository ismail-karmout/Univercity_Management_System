package com.umi.planingexamservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "exam")
    private String exam;

    @ManyToOne
    @JoinColumn(name = "planing_exam")
    private PlaningExam planingExam;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;
}
