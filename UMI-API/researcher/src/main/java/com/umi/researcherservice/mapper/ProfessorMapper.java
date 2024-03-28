package com.umi.researcherservice.mapper;

import com.umi.researcherservice.dto.ProfessorDto;
import com.umi.researcherservice.entity.Professor;

public class ProfessorMapper {
    public static ProfessorDto mapToProfessorDto(Professor professor){
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setId(professor.getId());
        professorDto.setFirstname(professor.getFirstname());
        professorDto.setLastname(professor.getLastname());
        professorDto.setPhone(professor.getPhone());
        professorDto.setEmail(professor.getEmail());
        professorDto.setLaboId(professor.getLaboId());
        professorDto.setLabo(professor.getLabo());
        professorDto.setTeamId(professor.getTeamId());
        professorDto.setTeam(professor.getTeam());
        professorDto.setSpeciality(professor.getSpeciality());
        professorDto.setProfessorRoles(professor.getProfessorRoles());
        professorDto.setCreated_at(professor.getCreated_at());
        professorDto.setUpdated_at(professor.getUpdated_at());
        return professorDto;
    }

    public static Professor mapToProfessor(ProfessorDto professorDto){
        Professor professor = new Professor();
        professor.setId(professorDto.getId());
        professor.setFirstname(professorDto.getFirstname());
        professor.setLastname(professorDto.getLastname());
        professor.setPhone(professorDto.getPhone());
        professor.setEmail(professorDto.getEmail());
        professor.setLaboId(professorDto.getLaboId());
        professor.setLabo(professorDto.getLabo());
        professor.setTeamId(professorDto.getTeamId());
        professor.setTeam(professorDto.getTeam());
        professor.setSpeciality(professor.getSpeciality());
        professor.setProfessorRoles(professorDto.getProfessorRoles());
        professor.setCreated_at(professorDto.getCreated_at());
        professor.setUpdated_at(professorDto.getUpdated_at());
        return professor;
    }


}
