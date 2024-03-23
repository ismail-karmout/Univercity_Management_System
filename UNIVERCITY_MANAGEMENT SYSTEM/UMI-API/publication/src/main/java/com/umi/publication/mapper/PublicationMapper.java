package com.umi.publication.mapper;

import com.umi.publication.dto.PublicationDTO;
import com.umi.publication.entity.Publication;

import java.util.List;
import java.util.stream.Collectors;

public class PublicationMapper {
    public static PublicationDTO mapToPublicationDTO(Publication publication){
        return new PublicationDTO(
                publication.getId(),
                publication.getType(),
                publication.getTitre(),
                publication.getAuteurId(),
                publication.getAnneeUniversitaireId(),
                publication.getEquipeId(),
                publication.getLaboId(),
                publication.getEtat(),
                publication.getJustificatif(),
                publication.getCreatedAt(),
                publication.getUpdatedAt()
        );
    }

    public static Publication mapToPublication(PublicationDTO publicationDTO) {
          return new Publication(
                  publicationDTO.getId(),
                  publicationDTO.getType(),
                  publicationDTO.getTitre(),
                  publicationDTO.getAuteurId(),
                  publicationDTO.getAnneeUniversitaireId(),
                  publicationDTO.getEquipeId(),
                  publicationDTO.getLaboId(),
                  publicationDTO.getEtat(),
                  publicationDTO.getJustificatif(),
                  publicationDTO.getCreatedAt(),
                  publicationDTO.getUpdatedAt()
        );
    }
    public static List<PublicationDTO> mapToPublicationDtoList(List<Publication> publications) {
        return publications.stream()
                .map(PublicationMapper::mapToPublicationDTO)
                .collect(Collectors.toList());
    }
}
