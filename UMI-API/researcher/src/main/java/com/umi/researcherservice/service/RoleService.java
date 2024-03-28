package com.umi.researcherservice.service;

import com.umi.researcherservice.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto RoleDto);
    RoleDto getRoleById(Long id);
    List<RoleDto> getAllRole();
    RoleDto updateRole(Long id, RoleDto updatedRole);
    void deleteRole(Long id);
}