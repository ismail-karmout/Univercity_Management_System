package com.umi.recherche.ecoledoctorale.repository;

import com.umi.recherche.ecoledoctorale.entity.EcoleDoctorale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleDoctoraleRepository extends JpaRepository<EcoleDoctorale,Long> {
}
