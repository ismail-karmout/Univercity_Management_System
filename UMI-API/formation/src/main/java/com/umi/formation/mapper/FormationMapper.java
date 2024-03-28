package com.umi.formation.mapper;

import com.umi.formation.dto.FormationDTO;
import com.umi.formation.entity.Formation;

import java.util.List;
import java.util.stream.Collectors;

public class FormationMapper {
    public static FormationDTO mapToFormationDTO(Formation formation){
        return new FormationDTO(
                formation.getId(),
                formation.getIntitule(),
                formation.getTypeFormation(),
                formation.getResponsable(),
                formation.getImageDescriptive(),
                formation.getDocumentDescriptifPath(),
                formation.getCreatedAt(),
                formation.getUpdatedAt()
        );
    }

    public static Formation mapToFormation(FormationDTO formationDTO) {
          return new Formation(
                formationDTO.getId(),
                formationDTO.getIntitule(),
                formationDTO.getTypeFormation(),
                formationDTO.getResponsable(),
                formationDTO.getImageDescriptive(),
                formationDTO.getDocumentDescriptifPath(),
                formationDTO.getCreatedAt(),
                formationDTO.getUpdatedAt()
        );
    }
    public static List<FormationDTO> mapToFormationDtoList(List<Formation> formations) {
        return formations.stream()
                .map(FormationMapper::mapToFormationDTO)
                .collect(Collectors.toList());
    }
}
