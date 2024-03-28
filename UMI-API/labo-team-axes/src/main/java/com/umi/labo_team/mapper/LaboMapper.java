package com.umi.labo_team.mapper;

import com.umi.labo_team.dto.LaboDto;
import com.umi.labo_team.entity.Labo;

public class LaboMapper {
    public static LaboDto mapToLaboDto(Labo labo){
        return new LaboDto(
                labo.getId(),
                labo.getAcroname(),
                labo.getSlug(),
                labo.getTitle(),
                labo.getCreated_at(),
                labo.getUpdated_at(),
                labo.getDeleted_at(),
                labo.getTeams(),
                labo.getRechercheAxes(),
                labo.getDepartment_id(),
                labo.getDepartment(),
                labo.getEcole_doctorale_id(),
                labo.getEcoleDoctorale()
        );
    }

    public static Labo mapToLabo(LaboDto laboDto){
        return new Labo(
                laboDto.getId(),
                laboDto.getAcroname(),
                laboDto.getSlug(),
                laboDto.getTitle(),
                laboDto.getCreated_at(),
                laboDto.getUpdated_at(),
                laboDto.getDeleted_at(),
                laboDto.getTeams(),
                laboDto.getDepartment_id(),
                laboDto.getDepartment(),
                laboDto.getEcole_doctorale_id(),
                laboDto.getEcoleDoctorale(),
                laboDto.getRechercheAxes()
                );
    }
}