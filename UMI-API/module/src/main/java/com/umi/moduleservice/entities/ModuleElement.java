package com.umi.moduleservice.entities;

import com.umi.moduleservice.model.Professor;
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
@Table(name = "module_element")
public class ModuleElement {
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
    @OneToMany
    @JoinColumn(name = "professor")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "module")
    private Module module;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;
}
