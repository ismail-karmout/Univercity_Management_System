package com.umi.labo_team.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.model.EcoleDoctorale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "labos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Labo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "acroname", nullable = false)
    private String acroname;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updated_at;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deleted_at;

    @OneToMany(mappedBy = "labo", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Team> teams;

    @JoinColumn(name = "department_id")
    @Column(name="department_id")
    private Long department_id ;
    @Transient
    private Department department;

    @JoinColumn(name = "ecole_doctorale_id")
    @Column(name="ecole_doctorale_id")
    private Long ecole_doctorale_id ;
    @Transient
    private EcoleDoctorale ecoleDoctorale;

    @ManyToMany
    @JoinTable(
            name = "labo_recherche_axes",
            joinColumns = @JoinColumn(name = "labo_id"),
            inverseJoinColumns = @JoinColumn(name = "recherche_axe_id")
    )
    private List<RechercheAxe> rechercheAxes;
}