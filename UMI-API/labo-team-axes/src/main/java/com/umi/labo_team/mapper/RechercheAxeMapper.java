package com.umi.labo_team.mapper;

import com.umi.labo_team.dto.RechercheAxeDto;
import com.umi.labo_team.entity.RechercheAxe;

public class RechercheAxeMapper {
    public static RechercheAxeDto mapTorechercheAxeDto(RechercheAxe rechercheAxe){
        return new RechercheAxeDto(
                rechercheAxe.getId(),
                rechercheAxe.getSlug(),
                rechercheAxe.getName(),
                rechercheAxe.getCreatedAt(),
                rechercheAxe.getUpdatedAt(),
                rechercheAxe.getDeletedAt()
        );
    }

    public static RechercheAxe mapToRechercheAxe (RechercheAxeDto rechercheAxe){
        return new RechercheAxe(
                rechercheAxe.getId(),
                rechercheAxe.getSlug(),
                rechercheAxe.getName(),
                rechercheAxe.getCreated_at(),
                rechercheAxe.getUpdated_at(),
                rechercheAxe.getDeleted_at()
        );
    }
}