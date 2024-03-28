package com.umi.departmentetablissement.department.service;

import com.umi.departmentetablissement.department.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment);
    void deleteDepartment(Long departmentId);
}
