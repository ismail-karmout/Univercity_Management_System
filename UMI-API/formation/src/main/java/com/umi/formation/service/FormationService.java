package com.umi.formation.service;
import com.umi.formation.dto.FormationDTO;

import java.util.List;


public interface FormationService {
    List<FormationDTO> getAllFormations();
    FormationDTO getFormationById(Long id);
    FormationDTO addFormation(FormationDTO formationDTO);
    FormationDTO updateFormation(Long id, FormationDTO formationDTO);
    void deleteFormation(Long id);}
