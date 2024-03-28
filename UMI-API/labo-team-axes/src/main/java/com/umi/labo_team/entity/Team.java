package com.umi.labo_team.entity;

import com.umi.labo_team.model.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "slug", nullable = false)
    private String slug;
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @JoinColumn(name = "department_id")
    @Column(name="department_id")
    private Long department_id ;
    @Transient
    private Department department;

    @ManyToOne
    @JoinColumn(name = "labo", nullable = false)
    private Labo labo;

    @ManyToMany
    @JoinTable(
            name = "team_recherche_axes",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "recherche_axe_id")
    )
    private List<RechercheAxe> rechercheAxes;

}
