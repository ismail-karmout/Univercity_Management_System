package com.umi.semestreservice.repository;

import com.umi.semestreservice.entity.AnneeUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.Optional;

public interface AnneeUniversitaireRepository extends JpaRepository<AnneeUniversitaire, Long> {
    // Méthode pour trouver une année universitaire courante
    Optional<AnneeUniversitaire> findByStartYearAndEndYear(Integer startYear, Integer endYear);

    AnneeUniversitaire findByCouranteTrue();
    boolean existsByStartYearAndEndYear(Integer startYear, Integer endYear);

}
