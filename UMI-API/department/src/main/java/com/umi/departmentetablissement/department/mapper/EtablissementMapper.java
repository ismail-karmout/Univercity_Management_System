package com.umi.departmentetablissement.department.mapper;

import com.umi.departmentetablissement.department.dto.EtablissementDto;
import com.umi.departmentetablissement.department.entity.Etablissement;

public class EtablissementMapper {
    public static EtablissementDto mapToEtablissementDto(Etablissement etablissement){
        return new EtablissementDto(
                etablissement.getId(),
                etablissement.getName(),
                etablissement.getDescription(),
                etablissement.getSlug(),
                etablissement.getCreated_at(),
                etablissement.getUpdated_at(),
                etablissement.getDeleted_at(),
                etablissement.getDepartments()
        );
    }

    public static Etablissement mapToEtablissement(EtablissementDto etablissementDto){
        return new Etablissement(
                etablissementDto.getId(),
                etablissementDto.getName(),
                etablissementDto.getDescription(),
                etablissementDto.getSlug(),
                etablissementDto.getCreated_at(),
                etablissementDto.getUpdated_at(),
                etablissementDto.getDeleted_at(),
                etablissementDto.getDepartments()
        );
    }
}