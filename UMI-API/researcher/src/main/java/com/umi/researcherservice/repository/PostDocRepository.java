package com.umi.researcherservice.repository;

import com.umi.researcherservice.entity.PostDoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDocRepository extends JpaRepository<PostDoc, Long> {
}
