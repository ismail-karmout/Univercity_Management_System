package com.umi.filiere.groupesection.repository;

import com.umi.filiere.groupesection.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {

}
