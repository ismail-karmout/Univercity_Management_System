package com.umi.researcherservice.mapper;

import com.umi.researcherservice.dto.PhdStudentDto;
import com.umi.researcherservice.entity.PhdStudent;

public class PhdStudentMapper {
    public static PhdStudentDto mapToPhdStudentDto(PhdStudent phdStudent){
        PhdStudentDto phdStudentDto = new PhdStudentDto();
        phdStudentDto.setId(phdStudent.getId());
        phdStudentDto.setFirstname(phdStudent.getFirstname());
        phdStudentDto.setLastname(phdStudent.getLastname());
        phdStudentDto.setPhone(phdStudent.getPhone());
        phdStudentDto.setEmail(phdStudent.getEmail());
        phdStudentDto.setLaboId(phdStudent.getLaboId());
        phdStudentDto.setLabo(phdStudent.getLabo());
        phdStudentDto.setTeamId(phdStudent.getTeamId());
        phdStudentDto.setTeam(phdStudent.getTeam());
        phdStudentDto.setCreated_at(phdStudent.getCreated_at());
        phdStudentDto.setUpdated_at(phdStudent.getUpdated_at());
        return phdStudentDto;
    }

    public static PhdStudent mapToPhdStudent(PhdStudentDto phdStudentDto){
        PhdStudent phdStudent = new PhdStudent();
        phdStudent.setId(phdStudentDto.getId());
        phdStudent.setFirstname(phdStudentDto.getFirstname());
        phdStudent.setLastname(phdStudentDto.getLastname());
        phdStudent.setPhone(phdStudentDto.getPhone());
        phdStudent.setEmail(phdStudentDto.getEmail());
        phdStudent.setLaboId(phdStudent.getLaboId());
        phdStudent.setLabo(phdStudent.getLabo());
        phdStudent.setTeamId(phdStudent.getTeamId());
        phdStudent.setTeam(phdStudent.getTeam());
        phdStudent.setCreated_at(phdStudentDto.getCreated_at());
        phdStudent.setUpdated_at(phdStudentDto.getUpdated_at());
        return phdStudent;
    }
}
