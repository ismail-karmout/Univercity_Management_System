package com.umi.departmentetablissement.department.service.impl;


import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.entity.Department;
import com.umi.departmentetablissement.department.exception.ResourceNotFoundException;
import com.umi.departmentetablissement.department.mapper.DepartmentMapper;
import com.umi.departmentetablissement.department.repository.DepartmentRepository;
import com.umi.departmentetablissement.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("The department is not exist with the given id: " + departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + departmentId));
        if (updateDepartment.getName() != null)
            department.setName(updateDepartment.getName());
        if (updateDepartment.getSlug() != null)
            department.setSlug(updateDepartment.getSlug());
        if (updateDepartment.getDescription() != null)
            department.setDescription(updateDepartment.getDescription());
        if (updateDepartment.getEtablissement() != null)
            department.setEtablissement(updateDepartment.getEtablissement());
        department.setUpdatedAt(LocalDateTime.now());
        Department updatedDepartmentObj = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + departmentId));
        departmentRepository.deleteById(departmentId);
    }
}
