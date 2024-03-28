package com.umi.recherche.ecoledoctorale.service;

import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleRequestDTO;
import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleResponseDTO;
import com.umi.recherche.ecoledoctorale.entity.EcoleDoctorale;

import java.util.List;

public interface EcoleDoctoraleService {
    EcoleDoctoraleResponseDTO createEcoleDoctorale(EcoleDoctoraleResponseDTO ecoleDoctoraleResponseDTO);
    public List<EcoleDoctorale> getAllEcoleDoctorales();
    public EcoleDoctorale getEcoleDoctoraleById(Long id);
    public EcoleDoctoraleResponseDTO updateEcoleDoctorale(Long id, EcoleDoctoraleRequestDTO ecoleDoctoraleRequestDTO);
    public Boolean deleteEcoleDoctorale(Long id);
}
