package com.umi.researcherservice.entity;

import com.umi.researcherservice.model.Labo;
import com.umi.researcherservice.model.Team;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "researcher_type")
@Table(name = "researcher")
public abstract class Researcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "labo_id")
    private Long laboId;
    @Transient
    @JoinColumn(name = "labo")
    private Labo labo;
    @Column(name = "team_id")
    private Long teamId;
    @Transient
    @JoinColumn(name = "team")
    private Team team;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

}
