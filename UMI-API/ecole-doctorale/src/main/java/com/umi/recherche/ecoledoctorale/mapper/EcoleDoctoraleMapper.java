package com.umi.recherche.ecoledoctorale.mapper;

import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleResponseDTO;
import com.umi.recherche.ecoledoctorale.entity.EcoleDoctorale;
import org.springframework.stereotype.Component;

@Component
public class EcoleDoctoraleMapper {

    public static EcoleDoctoraleResponseDTO mapToEcoleDoctoraleDto(EcoleDoctorale ecoleDoctorale){

        return new EcoleDoctoraleResponseDTO(
                ecoleDoctorale.getId(),
                ecoleDoctorale.getName(),
                ecoleDoctorale.getDescription(),
                ecoleDoctorale.getSlug(),
                ecoleDoctorale.getCreatedAt(),
                ecoleDoctorale.getUpdatedAt(),
                ecoleDoctorale.getDeletedAt()

        );
    }

    public static EcoleDoctorale mapToEcoleDoctorale(EcoleDoctoraleResponseDTO ecoleDoctoraleResponseDTO){
        return new EcoleDoctorale(
                ecoleDoctoraleResponseDTO.getId(),
                ecoleDoctoraleResponseDTO.getName(),
                ecoleDoctoraleResponseDTO.getDescription(),
                ecoleDoctoraleResponseDTO.getSlug(),
                ecoleDoctoraleResponseDTO.getCreated_at(),
                ecoleDoctoraleResponseDTO.getUpdated_at(),
                ecoleDoctoraleResponseDTO.getDeleted_at()
        );
    }
}
