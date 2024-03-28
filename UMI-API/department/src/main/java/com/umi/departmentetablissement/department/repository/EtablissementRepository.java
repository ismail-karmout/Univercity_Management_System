package com.umi.departmentetablissement.department.repository;

import com.umi.departmentetablissement.department.entity.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

}
