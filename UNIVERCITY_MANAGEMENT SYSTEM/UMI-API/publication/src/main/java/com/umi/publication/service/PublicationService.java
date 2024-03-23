package com.umi.publication.service;
import com.umi.publication.dto.PublicationDTO;
import com.umi.publication.entity.Publication;

import java.util.List;


public interface PublicationService {
    List<PublicationDTO> getAllPublications();
    PublicationDTO getPublicationById(Long id);
    PublicationDTO getPublicationByAnnee(Long anneeId);
    PublicationDTO getPublicationByAuteur(Long auteurId);
    PublicationDTO getPublicationByEquipe(Long equipeId);
    PublicationDTO getPublicationByLabo(Long laboId);
    PublicationDTO addPublication(PublicationDTO publicationDTO);
    PublicationDTO updatePublication(Long id, PublicationDTO publicationDTO);
    void deletePublication(Long id);}
