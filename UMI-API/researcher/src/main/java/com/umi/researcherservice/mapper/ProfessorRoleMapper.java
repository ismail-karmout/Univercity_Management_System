package com.umi.researcherservice.mapper;

import com.umi.researcherservice.dto.ProfessorRoleDto;
import com.umi.researcherservice.entity.ProfessorRole;

public class ProfessorRoleMapper {
    public  static ProfessorRoleDto mapToProfessorRoleDto(ProfessorRole professorRole){
        return  new ProfessorRoleDto(
                professorRole.getId(),
                professorRole.getProfessor(),
                professorRole.getRole(),
                professorRole.getProof(),
                professorRole.getCreated_at(),
                professorRole.getUpdated_at()
        );
    }

    public static ProfessorRole mapToProfessorRole(ProfessorRoleDto professorRoleDto){
        return new ProfessorRole(
                professorRoleDto.getId(),
                professorRoleDto.getProfessor(),
                professorRoleDto.getRole(),
                professorRoleDto.getProof(),
                professorRoleDto.getCreated_at(),
                professorRoleDto.getUpdated_at()
        );
    }
}
