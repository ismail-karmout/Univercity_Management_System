package com.umi.researcherservice.repository;

import com.umi.researcherservice.entity.PhdStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhdStudentRepository extends JpaRepository<PhdStudent, Long> {
}
