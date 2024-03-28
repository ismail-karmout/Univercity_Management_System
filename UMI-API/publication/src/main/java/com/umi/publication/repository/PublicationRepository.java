package com.umi.publication.repository;
import com.umi.publication.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    Optional<Publication> findByAnneeUniversitaireId(Long anneeId);
    Optional<Publication> findByAuteurId(Long auteurId);
    Optional<Publication> findByEquipeId(Long equipeId);
    Optional<Publication> findByLaboId(Long laboId);
}

