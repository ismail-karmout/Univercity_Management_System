package com.umi.moduleservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umi.moduleservice.model.Professor;
import com.umi.moduleservice.model.Semestre;
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
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "professor_id")
    private Long professorId;

    @Transient
    @JoinColumn(name = "professor")
    private Professor professor;

    @Column(name = "semester_id")
    private Long semestreId;

    @Transient
    @JoinColumn(name = "semester")
    private Semestre semestre;

    @OneToMany(mappedBy = "module")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ModuleElement> moduleElements;

    @CreationTimestamp
    @Column(name = "created_at")

    private Date created_at;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;
}
