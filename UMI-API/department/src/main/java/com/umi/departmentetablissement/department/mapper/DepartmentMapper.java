package com.umi.departmentetablissement.department.mapper;

import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){

        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getSlug(),
                department.getCreatedAt(),
                department.getUpdatedAt(),
                department.getDeletedAt(),
                department.getEtablissement()

        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getSlug(),
                departmentDto.getCreated_at(),
                departmentDto.getUpdated_at(),
                departmentDto.getDeleted_at(),
                departmentDto.getEtablissement()
        );
    }
}
