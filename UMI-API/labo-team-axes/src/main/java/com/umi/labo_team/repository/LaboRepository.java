package com.umi.labo_team.repository;

import com.umi.labo_team.entity.Labo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboRepository extends JpaRepository<Labo, Long> {


}
