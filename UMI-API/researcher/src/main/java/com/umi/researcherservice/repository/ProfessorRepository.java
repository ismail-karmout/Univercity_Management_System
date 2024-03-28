package com.umi.researcherservice.repository;

import com.umi.researcherservice.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
