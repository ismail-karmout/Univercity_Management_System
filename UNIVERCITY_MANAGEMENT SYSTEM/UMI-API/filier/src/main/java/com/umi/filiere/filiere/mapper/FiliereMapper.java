package com.umi.filiere.filiere.mapper;

import com.umi.filiere.filiere.dto.FiliereDto;
import com.umi.filiere.filiere.entity.Filiere;

import java.util.List;
import java.util.stream.Collectors;

public class FiliereMapper {
    public static FiliereDto mapToFiliereDto(Filiere filiere) {
        return new FiliereDto(
                filiere.getId(),
                filiere.getName(),
                filiere.getNbAnnees(),
                filiere.getNbSemestres(),
                filiere.getResponsable(),
                filiere.getAnneeDiplomante(),
                filiere.getAnneesNonDiplomantes(),
                filiere.getSlug(),
                filiere.getListeSemestres(),
                filiere.getDepartment_id(),
                filiere.getDepartment(),
                filiere.getCreatedAt(),
                filiere.getUpdatedAt()
        );
    }

    public static Filiere mapToFiliere(FiliereDto filiereDto) {
        return new Filiere(
        filiereDto.getId(),
        filiereDto.getName(),
        filiereDto.getNbAnnees(),
        filiereDto.getNbSemestres(),
        filiereDto.getResponsable(),
        filiereDto.getAnneeDiplomante(),
        filiereDto.getAnneesNonDipolomantes(),
        filiereDto.getSlug(),
        filiereDto.getListeSemestres(),
        filiereDto.getDepartment_id(),
        filiereDto.getDepartment(),
        filiereDto.getCreatedAt(),
        filiereDto.getUpdatedAt()
        );
    }
    public static List<FiliereDto> mapToFiliereDtoList(List<Filiere> filieres) {
        return filieres.stream()
                .map(FiliereMapper::mapToFiliereDto)
                .collect(Collectors.toList());
    }
}
