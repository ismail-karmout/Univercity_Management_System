package com.umi.publication.service.impl;

import com.umi.publication.dto.PublicationDTO;
import com.umi.publication.entity.Publication;
import com.umi.publication.exception.PublicationNotFoundException;
import com.umi.publication.mapper.PublicationMapper;
import com.umi.publication.repository.PublicationRepository;
import com.umi.publication.service.PublicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    public final PublicationRepository publicationRepository;


    @Override
    public List<PublicationDTO> getAllPublications() {
        List<Publication> publications = publicationRepository.findAll();
        return PublicationMapper.mapToPublicationDtoList(publications);
    }

    @Override
    public PublicationDTO getPublicationById(Long id) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new PublicationNotFoundException("Publication not found with id: " + id));
        return PublicationMapper.mapToPublicationDTO(publication);
    }

    @Override
    public PublicationDTO getPublicationByAnnee(Long anneeId) {
        // Utilisez la méthode du repository pour rechercher une publication par l'identifiant de l'année
        Publication publication = publicationRepository.findByAnneeUniversitaireId(anneeId)
                .orElseThrow(() -> new PublicationNotFoundException("Publication not found with idAnnee: " + anneeId));

        // Utilisez un mapper pour mapper l'entité Publication à PublicationDTO
        return PublicationMapper.mapToPublicationDTO(publication);
    }


    @Override
    public PublicationDTO getPublicationByAuteur(Long auteurId) {
        Publication publication = publicationRepository.findByAuteurId(auteurId)
                .orElseThrow(() -> new PublicationNotFoundException("Publication not found with idAuteur: " + auteurId));
        return PublicationMapper.mapToPublicationDTO(publication);
    }


    @Override
    public PublicationDTO getPublicationByEquipe(Long equipeId) {
        Publication publication = publicationRepository.findByEquipeId(equipeId)
                .orElseThrow(() -> new PublicationNotFoundException("Publication not found with idEquipe: " + equipeId));
        return PublicationMapper.mapToPublicationDTO(publication);
    }


    @Override
    public PublicationDTO getPublicationByLabo(Long laboId) {
        Publication publication = publicationRepository.findByLaboId(laboId)
                .orElseThrow(() -> new PublicationNotFoundException("Publication not found with idLabo: " + laboId));
        return PublicationMapper.mapToPublicationDTO(publication);
    }


    @Override
    public PublicationDTO addPublication(PublicationDTO publicationDTO) {
        Publication nouvellePublication = PublicationMapper.mapToPublication(publicationDTO);
        nouvellePublication.setCreatedAt(LocalDateTime.now());
        Publication savedPublication = publicationRepository.save(nouvellePublication);
        return PublicationMapper.mapToPublicationDTO(savedPublication);
    }

    @Override
    public PublicationDTO updatePublication(Long id, PublicationDTO publicationDTO) {
        Publication publicationExistante = publicationRepository.findById(id)
                .orElseThrow(() -> new PublicationNotFoundException("Publication not found with id: " + id));

        Publication pMiseAJour = PublicationMapper.mapToPublication(publicationDTO);
        pMiseAJour.setId(publicationExistante.getId());
        pMiseAJour.setType(publicationDTO.getType());
        pMiseAJour.setTitre(publicationDTO.getTitre());
        pMiseAJour.setAuteurId(publicationDTO.getAuteurId());
        pMiseAJour.setAnneeUniversitaireId(publicationDTO.getAnneeUniversitaireId());
        pMiseAJour.setEquipeId(publicationDTO.getEquipeId());
        pMiseAJour.setLaboId(publicationDTO.getLaboId());
        pMiseAJour.setEtat(publicationDTO.getEtat());
        pMiseAJour.setJustificatif(publicationDTO.getJustificatif());
        pMiseAJour.setCreatedAt(publicationExistante.getCreatedAt());
        pMiseAJour.setUpdatedAt(LocalDateTime.now());

        Publication savedPublication = publicationRepository.save(pMiseAJour);
        return PublicationMapper.mapToPublicationDTO(savedPublication);
    }

    @Override
    public void deletePublication(Long id) {
        if (!publicationRepository.existsById(id)) {
            throw new PublicationNotFoundException("Publication is not exists with given id : " + id);
        }
        publicationRepository.deleteById(id);
    }


}
