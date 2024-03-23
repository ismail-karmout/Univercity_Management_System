package com.umi.semestreservice.mapper;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.dto.SemestreDto;
import com.umi.semestreservice.entity.AnneeUniversitaire;
import com.umi.semestreservice.entity.Semestre;

import java.util.List;
import java.util.stream.Collectors;

public class SemestreMapper {
    public static SemestreDto mapToSemestreDto(Semestre semestre) {
        return new SemestreDto(semestre.getId(), semestre.getName(),semestre.getIdAcademicYear(), semestre.getSession(),semestre.getTypeSession(),semestre.getIdFiliere(),semestre.getCreatedAt(), semestre.getUpdatedAt());
    }

    public static Semestre mapToSemestre(SemestreDto semestreDto) {
        return new Semestre(semestreDto.getId(), semestreDto.getName(),semestreDto.getIdAcademicYear(), semestreDto.getSession(),semestreDto.getTypeSession(),semestreDto.getIdFiliere(), semestreDto.getCreatedAt(), semestreDto.getUpdatedAt());
    }
    public static List<SemestreDto> mapToSemestreDtoList(List<Semestre> semestres) {
        return semestres.stream()
                .map(SemestreMapper::mapToSemestreDto)
                .collect(Collectors.toList());
    }
}
