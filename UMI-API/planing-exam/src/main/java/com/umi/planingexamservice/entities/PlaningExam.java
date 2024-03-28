package com.umi.planingexamservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umi.planingexamservice.model.Semestre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planing_exam")
public class PlaningExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "avis")
    private String avis;
    @Column(name = "planing")
    private String planing;
    @Column(name = "semester_id")
    private Long semestreId;

    @Transient
    @JoinColumn(name = "semester")
    private Semestre semestre;
    @OneToMany(mappedBy = "planingExam")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Exam> exams;

//    @Lob
//    @Column(name = "file_data", columnDefinition="LONGBLOB")
//    private byte[] fileData;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;
}
