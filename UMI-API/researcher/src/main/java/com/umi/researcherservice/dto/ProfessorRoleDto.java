package com.umi.researcherservice.dto;

import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.entity.Role;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRoleDto {
    private Long id;
    private Professor professor;
    private Role role;
    private String proof;
    private Date created_at;
    private Date updated_at;
}
