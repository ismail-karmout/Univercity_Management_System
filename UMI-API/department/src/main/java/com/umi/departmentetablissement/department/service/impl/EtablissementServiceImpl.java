package com.umi.departmentetablissement.department.service.impl;

import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.dto.EtablissementDto;
import com.umi.departmentetablissement.department.entity.Department;
import com.umi.departmentetablissement.department.entity.Etablissement;
import com.umi.departmentetablissement.department.exception.ResourceNotFoundException;
import com.umi.departmentetablissement.department.mapper.DepartmentMapper;
import com.umi.departmentetablissement.department.mapper.EtablissementMapper;
import com.umi.departmentetablissement.department.repository.EtablissementRepository;
import com.umi.departmentetablissement.department.service.EtablissementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtablissementServiceImpl implements EtablissementService {

    private final EtablissementRepository etablissementRepository;

    @Override
    public EtablissementDto createEtablissement(EtablissementDto etablissementDto) {
        Etablissement etablissement = EtablissementMapper.mapToEtablissement(etablissementDto);
        Etablissement savedDepartment = etablissementRepository.save(etablissement);
        return EtablissementMapper.mapToEtablissementDto(savedDepartment);
    }


    @Override
    public EtablissementDto getEtablissementById(Long etablissementId) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId).orElseThrow(() -> new ResourceNotFoundException("The etablissement is not exist with the given id: " + etablissementId));
        return EtablissementMapper.mapToEtablissementDto(etablissement);
    }

    @Override
    public List<EtablissementDto> getAllEtablissements() {
        List<Etablissement> etablissements = etablissementRepository.findAll();
        return etablissements.stream().map((etablissement) -> EtablissementMapper.mapToEtablissementDto(etablissement)).collect(Collectors.toList());
    }

    @Override
    public EtablissementDto updateEtablissement(Long etablissementId, EtablissementDto updatedEtablissement) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId).orElseThrow(() -> new ResourceNotFoundException("Etablissement is not exist with given id: " + etablissementId));
        if (updatedEtablissement.getName() != null)
            etablissement.setName(updatedEtablissement.getName());
        if (updatedEtablissement.getSlug() != null)
            etablissement.setSlug(updatedEtablissement.getSlug());
        if (updatedEtablissement.getDescription() != null)
            etablissement.setDescription(updatedEtablissement.getDescription());
        etablissement.setUpdated_at(LocalDateTime.now());


        Etablissement updatedEtablissementObj = etablissementRepository.save(etablissement);
        return EtablissementMapper.mapToEtablissementDto(updatedEtablissementObj);
    }

    @Override
    public void deleteEtablissement(Long etablissementId) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId).orElseThrow(() -> new ResourceNotFoundException("Etablissement is not exist with given id: " + etablissementId));
        etablissementRepository.deleteById(etablissementId);

    }
}
