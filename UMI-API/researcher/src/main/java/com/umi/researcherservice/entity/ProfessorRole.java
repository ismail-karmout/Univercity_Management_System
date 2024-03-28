package com.umi.researcherservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "professor_role")
public class ProfessorRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Professor professor;
    @ManyToOne
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Role role;
    private String proof;
    @CreationTimestamp
    private Date created_at;
    @UpdateTimestamp
    private Date updated_at;

}
