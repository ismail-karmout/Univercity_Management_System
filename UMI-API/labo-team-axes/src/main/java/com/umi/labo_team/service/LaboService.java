package com.umi.labo_team.service;

import com.umi.labo_team.dto.LaboDto;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.model.EcoleDoctorale;

import java.util.List;

public interface LaboService {
    LaboDto createLabo(LaboDto laboDto);
    LaboDto getLaboById(Long laboId);
    void assignLaboToDepartment(Long laboId, Long departmentId);
    List<LaboDto> getAllLabos();
    Department getDepartmentById(Long id);
    EcoleDoctorale getEcoleDoctorale(Long id);
    List<Department> getAllDepartments();
    LaboDto updateLabo(Long laboId, LaboDto laboDto);
    void deleteLabo(Long laboId);

}
