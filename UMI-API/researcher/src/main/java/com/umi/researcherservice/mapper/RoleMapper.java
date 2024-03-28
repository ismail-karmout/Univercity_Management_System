package com.umi.researcherservice.mapper;

import com.umi.researcherservice.dto.RoleDto;
import com.umi.researcherservice.entity.Role;

public class RoleMapper {
    public static RoleDto mapToRoleDto(Role role){
        return new RoleDto(
                role.getId(),
                role.getName(),
                role.getRoleType(),
                role.getProfessorRoles(),
                role.getCreated_at(),
                role.getUpdated_at()
        );
    }
    public static Role mapToRole(RoleDto roleDto){
        return new Role(
                roleDto.getId(),
                roleDto.getName(),
                roleDto.getRoleType(),
                roleDto.getProfessorRoles(),
                roleDto.getCreated_at(),
                roleDto.getUpdated_at()
        );
    }
}
