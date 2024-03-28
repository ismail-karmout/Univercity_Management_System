package com.umi.semestreservice.service;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;

import java.util.List;

public interface AnneeUniversitaireService {
    AnneeUniversitaireDto createAnneeUniversitaire(AnneeUniversitaireDto anneeUniversitaireDto);

    AnneeUniversitaireDto getAnneeUniversitaireById(Long id);

    List<AnneeUniversitaireDto> getAllAnneeUniversitaire();

    AnneeUniversitaireDto updateAnneeUniversitaire(Long id, AnneeUniversitaireDto updatedAnneeUniversitaireDto);

    void deleteAnneeUniversitaire(Long id);
}
