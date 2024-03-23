package com.umi.semestreservice.service.impl;

import java.time.LocalDateTime;
import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.entity.AnneeUniversitaire;
import com.umi.semestreservice.exception.ResourceNotFoundException;
import com.umi.semestreservice.mapper.AnneeUniversitaireMapper;
import com.umi.semestreservice.repository.AnneeUniversitaireRepository;
import com.umi.semestreservice.service.AnneeUniversitaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnneeUniversitaireServiceImpl  implements AnneeUniversitaireService {
    private AnneeUniversitaireRepository anneeUniversitaireRepository;



    @Override
    public AnneeUniversitaireDto createAnneeUniversitaire(AnneeUniversitaireDto anneeUniversitaireDto) {

        // Vérifier si une année universitaire avec la même paire startYear-endYear existe déjà
        Integer startYear = anneeUniversitaireDto.getStartYear();
        Integer endYear = anneeUniversitaireDto.getEndYear();

        if (startYear.equals(endYear)) {
            throw new RuntimeException("Start year and end year must be different");
        }

        if (endYear != startYear + 1) {
            throw new RuntimeException("End year must be equal to start year plus one");
        }

        // Vérifier si une année universitaire avec la même paire startYear-endYear existe déjà
        if (anneeUniversitaireRepository.existsByStartYearAndEndYear(startYear, endYear)) {
            throw new RuntimeException("AnneeUniversitaire with the same startYear-endYear already exists");
        }

        // Chercher l'année courante dans la base de données
        AnneeUniversitaire anneeCourante = anneeUniversitaireRepository.findByCouranteTrue();
        if (anneeCourante != null) {
            // Désactiver l'année courante précédente
            anneeCourante.setCourante(false);
            anneeUniversitaireRepository.save(anneeCourante);
        }

        // Créer la nouvelle année universitaire
        AnneeUniversitaire anneeUniversitaire = AnneeUniversitaireMapper.mapToAnneeUniversitaire(anneeUniversitaireDto);
        AnneeUniversitaire savedAnneeUniversitaire = anneeUniversitaireRepository.save(anneeUniversitaire);

        return AnneeUniversitaireMapper.mapToAnneeUniversitaireDto(savedAnneeUniversitaire);
    }



    @Override
    public AnneeUniversitaireDto getAnneeUniversitaireById(Long id) {
        // Rechercher l'année universitaire par son ID
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University Year not found with id: " + id));

        // Mapper et retourner l'année universitaire trouvée
        return AnneeUniversitaireMapper.mapToAnneeUniversitaireDto(anneeUniversitaire);
    }


    @Override
    public List<AnneeUniversitaireDto> getAllAnneeUniversitaire() {
        List<AnneeUniversitaire> anneesUniversitaires = anneeUniversitaireRepository.findAll();
        return AnneeUniversitaireMapper.mapToAnneeUniversitaireDtoList(anneesUniversitaires);
    }


    @Override
    public AnneeUniversitaireDto updateAnneeUniversitaire(Long id, AnneeUniversitaireDto updatedAnneeUniversitaireDto) {
        // Recherche de l'année universitaire à mettre à jour
        Optional<AnneeUniversitaire> anneeUniversitaireOptional = anneeUniversitaireRepository.findById(id);

        // Vérifier si l'année universitaire existe
        if (anneeUniversitaireOptional.isEmpty()) {
            throw new RuntimeException("Annee universitaire introuvable avec l'ID : " + id);
        }

        // Récupérer l'année universitaire à mettre à jour
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireOptional.get();

        // Mettre à jour la date de mise à jour
        anneeUniversitaire.setUpdatedAt(LocalDateTime.now());

        // Vérifier si l'année universitaire doit être marquée comme courante
        if (updatedAnneeUniversitaireDto.getCourante()) {
            // Recherche de l'année universitaire courante
            AnneeUniversitaire currentAnneeUniversitaire = anneeUniversitaireRepository.findByCouranteTrue();

            // Vérifier si une autre année universitaire est déjà marquée comme courante
            if (currentAnneeUniversitaire != null && !currentAnneeUniversitaire.getId().equals(id)) {
                // Désactiver l'année universitaire courante précédente
                currentAnneeUniversitaire.setCourante(false);
                anneeUniversitaireRepository.save(currentAnneeUniversitaire);
            }
        }

        // Mettre à jour startYear et endYear si fournis et valides
        if (updatedAnneeUniversitaireDto.getStartYear() != null && updatedAnneeUniversitaireDto.getEndYear() != null) {
            int calculatedEndYear = updatedAnneeUniversitaireDto.getStartYear() + 1;
            if (!Objects.equals(updatedAnneeUniversitaireDto.getEndYear(), calculatedEndYear)) {
                throw new IllegalArgumentException("La fin de l'année universitaire doit être égale à l'année de début + 1");
            }
            anneeUniversitaire.setStartYear(updatedAnneeUniversitaireDto.getStartYear());
            anneeUniversitaire.setEndYear(updatedAnneeUniversitaireDto.getEndYear());
            anneeUniversitaire.setCourante(updatedAnneeUniversitaireDto.getCourante());
        }
//        anneeUniversitaire.setSemestres(updatedAnneeUniversitaireDto.getSemestres());

        // Enregistrer les modifications dans la base de données
        AnneeUniversitaire updatedAnneeUniversitaire = anneeUniversitaireRepository.save(anneeUniversitaire);

        // Mapper l'objet mis à jour vers un DTO et le renvoyer
        return AnneeUniversitaireMapper.mapToAnneeUniversitaireDto(updatedAnneeUniversitaire);
    }

    @Override
    public void deleteAnneeUniversitaire(Long id) {
        if (!anneeUniversitaireRepository.existsById(id)) {
            throw new ResourceNotFoundException("University is not existing with given id : " + id);
        }
        anneeUniversitaireRepository.deleteById(id);
    }
}
