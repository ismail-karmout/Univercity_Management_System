package com.umi.studentservice.entity;

import com.umi.studentservice.model.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "cne")
    private String cne;
    @Column(name = "cni")
    private String cni;
    @Column(name = "goup_id")
    private Long groupId;
    @Transient
    @JoinColumn(name = "group" )
    private Group group;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

}

