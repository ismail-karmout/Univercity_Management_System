package com.umi.semestreservice.mapper;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.entity.AnneeUniversitaire;

import java.util.List;
import java.util.stream.Collectors;

public class AnneeUniversitaireMapper {
    public static AnneeUniversitaireDto mapToAnneeUniversitaireDto(AnneeUniversitaire anneeUniversitaire) {
        return new AnneeUniversitaireDto(
                anneeUniversitaire.getId(),  // Ajouter l'ID ici
                anneeUniversitaire.getCourante(),
                anneeUniversitaire.getStartYear(),
                anneeUniversitaire.getEndYear(),
//                anneeUniversitaire.getSemestres(),
                anneeUniversitaire.getCreatedAt(),
                anneeUniversitaire.getUpdatedAt());
    }


    public static AnneeUniversitaire mapToAnneeUniversitaire(AnneeUniversitaireDto anneeUniversitaireDto) {
        return new AnneeUniversitaire(
                anneeUniversitaireDto.getId(),
                anneeUniversitaireDto.getCourante(),
                anneeUniversitaireDto.getStartYear(),
                anneeUniversitaireDto.getEndYear(),
//                anneeUniversitaireDto.getSemestres(),
                anneeUniversitaireDto.getCreatedAt(),
                anneeUniversitaireDto.getUpdatedAt());
    }
    public static List<AnneeUniversitaireDto> mapToAnneeUniversitaireDtoList(List<AnneeUniversitaire> anneesUniversitaires) {
        return anneesUniversitaires.stream()
                .map(AnneeUniversitaireMapper::mapToAnneeUniversitaireDto)
                .collect(Collectors.toList());
    }
}
