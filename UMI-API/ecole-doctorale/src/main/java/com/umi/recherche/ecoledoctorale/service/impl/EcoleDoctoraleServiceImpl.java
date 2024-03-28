package com.umi.recherche.ecoledoctorale.service.impl;

import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleRequestDTO;
import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleResponseDTO;
import com.umi.recherche.ecoledoctorale.entity.EcoleDoctorale;
import com.umi.recherche.ecoledoctorale.mapper.EcoleDoctoraleMapper;
import com.umi.recherche.ecoledoctorale.repository.EcoleDoctoraleRepository;
import com.umi.recherche.ecoledoctorale.service.EcoleDoctoraleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EcoleDoctoraleServiceImpl implements EcoleDoctoraleService {
    @Autowired
    private EcoleDoctoraleMapper ecoleDoctoraleMapper;
    @Autowired
    private EcoleDoctoraleRepository ecoleDoctoraleRepository;

    @Override
    public EcoleDoctoraleResponseDTO createEcoleDoctorale(EcoleDoctoraleResponseDTO ecoleDoctoraleResponseDTO) {
        EcoleDoctorale ecoleDoctorale = EcoleDoctoraleMapper.mapToEcoleDoctorale(ecoleDoctoraleResponseDTO);
        ecoleDoctorale.setCreatedAt(LocalDateTime.now());
        EcoleDoctorale savedEcoleDoctorale = ecoleDoctoraleRepository.save(ecoleDoctorale);
        return EcoleDoctoraleMapper.mapToEcoleDoctoraleDto(savedEcoleDoctorale);
    }

    @Override
    public List<EcoleDoctorale> getAllEcoleDoctorales() {
        return ecoleDoctoraleRepository.findAll();
    }

    @Override
    public EcoleDoctorale getEcoleDoctoraleById(Long id) {
        return ecoleDoctoraleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Ecole doctorale %s not found !", id)));
    }


    @Override
    public EcoleDoctoraleResponseDTO updateEcoleDoctorale(Long id, EcoleDoctoraleRequestDTO ecoleDoctoraleRequestDTO) {
        EcoleDoctorale ecoleDoctorale=EcoleDoctorale.builder()
                .id(id)
                .name(ecoleDoctoraleRequestDTO.getName())
                .description(ecoleDoctoraleRequestDTO.getDescription())
                .slug(ecoleDoctoraleRequestDTO.getSlug())
                .createdAt(ecoleDoctoraleRequestDTO.getCreated_at())
                .updatedAt(LocalDateTime.now())
                .deletedAt(ecoleDoctoraleRequestDTO.getDeleted_at())
                .build();
        EcoleDoctorale savedEcoleDoctorale=ecoleDoctoraleRepository.save(ecoleDoctorale);
        EcoleDoctoraleResponseDTO ecoleDoctoraleResponseDTO=ecoleDoctoraleMapper.mapToEcoleDoctoraleDto(savedEcoleDoctorale);
        return ecoleDoctoraleResponseDTO;
    }

    @Override
    public Boolean deleteEcoleDoctorale(Long id) {
        ecoleDoctoraleRepository.deleteById(id);
        return true;
    }
}
