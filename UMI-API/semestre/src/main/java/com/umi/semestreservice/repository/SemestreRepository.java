package com.umi.semestreservice.repository;

import com.umi.semestreservice.entity.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
}
