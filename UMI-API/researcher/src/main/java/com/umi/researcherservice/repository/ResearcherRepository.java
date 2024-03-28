package com.umi.researcherservice.repository;

import com.umi.researcherservice.entity.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearcherRepository  extends JpaRepository<Researcher, Long> {
}
