package com.umi.departmentetablissement.department.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "etablissements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Etablissement {
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

    @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Department> departments;
}
