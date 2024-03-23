package com.umi.formation.service.impl;

import com.umi.formation.dto.FormationDTO;
import com.umi.formation.entity.Formation;
import com.umi.formation.exception.FormationNotFoundException;
import lombok.AllArgsConstructor;
import com.umi.formation.mapper.FormationMapper;
import org.springframework.stereotype.Service;
import com.umi.formation.repository.FormationRepository;
import com.umi.formation.service.FormationService;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {
    public final FormationRepository formationRepository;


    @Override
    public List<FormationDTO> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        return FormationMapper.mapToFormationDtoList(formations);
    }

    @Override
    public FormationDTO getFormationById(Long id) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFoundException("Formation not found with id: " + id));
        return FormationMapper.mapToFormationDTO(formation);
    }

    @Override
    public FormationDTO addFormation(FormationDTO formationDTO) {
        Formation nouvelleFormation = FormationMapper.mapToFormation(formationDTO);
        nouvelleFormation.setCreatedAt(LocalDateTime.now());
        Formation savedFormation = formationRepository.save(nouvelleFormation);
        return FormationMapper.mapToFormationDTO(savedFormation);
    }

    @Override
    public FormationDTO updateFormation(Long id, FormationDTO formationDTO) {
        Formation formationExistante = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFoundException("Formation not found with id: " + id));

        Formation formationMiseAJour = FormationMapper.mapToFormation(formationDTO);
        formationMiseAJour.setId(formationExistante.getId());
        formationMiseAJour.setIntitule(formationDTO.getIntitule());
        formationMiseAJour.setTypeFormation(formationDTO.getTypeFormation());
        formationMiseAJour.setResponsable(formationDTO.getResponsable());
        formationMiseAJour.setImageDescriptive(formationDTO.getImageDescriptive());
        formationMiseAJour.setDocumentDescriptifPath(formationDTO.getDocumentDescriptifPath());
        formationMiseAJour.setCreatedAt(formationExistante.getCreatedAt());
        formationMiseAJour.setUpdatedAt(LocalDateTime.now());

        Formation savedFormation = formationRepository.save(formationMiseAJour);
        return FormationMapper.mapToFormationDTO(savedFormation);
    }

    @Override
    public void deleteFormation(Long id) {
        if (!formationRepository.existsById(id)) {
            throw new FormationNotFoundException("Formation is not exists with given id : " + id);
        }
        formationRepository.deleteById(id);
    }


}
