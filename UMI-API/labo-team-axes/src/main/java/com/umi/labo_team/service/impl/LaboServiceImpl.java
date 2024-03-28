package com.umi.labo_team.service.impl;

import com.umi.labo_team.dto.LaboDto;
import com.umi.labo_team.entity.Labo;
import com.umi.labo_team.exception.ResourceNotFoundException;
import com.umi.labo_team.feign.DepartmentServiceClient;
import com.umi.labo_team.feign.EcoleDoctoraleServiceClient;
import com.umi.labo_team.mapper.LaboMapper;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.model.EcoleDoctorale;
import com.umi.labo_team.repository.LaboRepository;
import com.umi.labo_team.service.LaboService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LaboServiceImpl implements LaboService {

    private final LaboRepository laboRepository;
    private final DepartmentServiceClient departmentServiceClient;
    private final EcoleDoctoraleServiceClient ecoleDoctoraleServiceClient;

    @Override
    public LaboDto createLabo(LaboDto etablissementDto) {
        Labo labo = LaboMapper.mapToLabo(etablissementDto);
        Labo savedLabo = laboRepository.save(labo);
        return LaboMapper.mapToLaboDto(savedLabo);
    }

    @Override
    public LaboDto getLaboById(Long etablissementId) {
        Labo labo = laboRepository.findById(etablissementId).orElseThrow(() -> new ResourceNotFoundException("The etablissement is not exist with the given id: " + etablissementId));
        return LaboMapper.mapToLaboDto(labo);
    }

    @Override
    public void assignLaboToDepartment(Long laboID, Long departmentId) {
        Labo labo = laboRepository.findById(laboID).orElseThrow(
                ()-> new ResourceNotFoundException("Labo is not exist with given id "+ laboID)
        );
        Department department = departmentServiceClient.getDepartmentById(departmentId);

        if (labo != null && department != null) {
            LaboDto laboDto = LaboMapper.mapToLaboDto(labo);
            this.updateLabo(labo.getId(), laboDto);
        } else {
            // Handle case when product or category is not found
        }

//        Labo labo = laboRepository.findById(laboID).orElseThrow(
//                ()-> new ResourceNotFoundException("Department is not exist with given id "+ laboID)
//        );
//
//        Department department = departmentServiceClient.getDepartmentById(departmentId);
//        labo.setDepartment(department);
//        Department saveLabo = laboRepository.save(labo).getDepartment();
    }
    @Override
    public List<LaboDto> getAllLabos() {
        List<Labo> labos = laboRepository.findAll();
        return labos.stream().map(LaboMapper::mapToLaboDto).collect(Collectors.toList());
//        return labos.stream().map((labo) -> LaboMapper.mapToLaboDto(labo)).collect(Collectors.toList());
    }

    @Override
    public Department getDepartmentById(Long id) {
           return departmentServiceClient.getDepartmentById(id);
    }

    @Override
    public EcoleDoctorale getEcoleDoctorale(Long id) {
        return ecoleDoctoraleServiceClient.getEcoleDoctoraleById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentServiceClient.getAllDepartments();
    }

    @Override
    public LaboDto updateLabo(Long laboId, LaboDto updatedLabo) {
        Labo labo = laboRepository.findById(laboId).orElseThrow(() -> new ResourceNotFoundException("Etablissement is not exist with given id: " + laboId));
        if (updatedLabo.getAcroname() != null)
            labo.setAcroname(updatedLabo.getAcroname());
        if (updatedLabo.getSlug() != null)
            labo.setSlug(updatedLabo.getSlug());
        if (updatedLabo.getTitle() != null)
            labo.setTitle(updatedLabo.getTitle());
        labo.setUpdated_at(LocalDateTime.now());
        Labo updatedEtablissementObj = laboRepository.save(labo);
        return LaboMapper.mapToLaboDto(updatedEtablissementObj);
    }

    @Override
    public void deleteLabo(Long laboId) {
        Labo labo = laboRepository.findById(laboId).orElseThrow(() -> new ResourceNotFoundException("Etablissement is not exist with given id: " + laboId));
        laboRepository.deleteById(laboId);

    }
}