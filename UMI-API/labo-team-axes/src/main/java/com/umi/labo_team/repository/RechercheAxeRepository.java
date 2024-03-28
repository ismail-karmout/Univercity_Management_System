package com.umi.labo_team.repository;

import com.umi.labo_team.entity.RechercheAxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechercheAxeRepository extends JpaRepository<RechercheAxe, Long> {

}
