package com.umi.researcherservice.service.impl;

import com.umi.researcherservice.dto.PhdStudentDto;
import com.umi.researcherservice.entity.PhdStudent;
import com.umi.researcherservice.exception.ResourceNotFoundException;
import com.umi.researcherservice.feign.LaboServiceClient;
import com.umi.researcherservice.mapper.PhdStudentMapper;
import com.umi.researcherservice.model.Labo;
import com.umi.researcherservice.model.Team;
import com.umi.researcherservice.repository.PhdStudentRepository;
import com.umi.researcherservice.service.PhdStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PhdStudentServiceImpl implements PhdStudentService {
    private PhdStudentRepository phdStudentRepository;
    private LaboServiceClient laboServiceClient;

    @Override
    public PhdStudentDto createPhdStudent(PhdStudentDto phdStudentDto) {
        PhdStudent phdStudent = PhdStudentMapper.mapToPhdStudent(phdStudentDto);
        PhdStudent createdPhdStudent = phdStudentRepository.save(phdStudent);
        return PhdStudentMapper.mapToPhdStudentDto(createdPhdStudent);
    }

    @Override
    public PhdStudentDto getPhdStudentById(Long id) {
        PhdStudent phdStudent = phdStudentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PhdStudent is not exits with given id "+id));

        if(phdStudent.getLaboId()!= null){
            phdStudent.setLabo(laboServiceClient.getLaboById(phdStudent.getLaboId()));
        }
        if(phdStudent.getTeamId()!= null){
            phdStudent.setTeam(laboServiceClient.getTeamById(phdStudent.getTeamId()));
        }

        return PhdStudentMapper.mapToPhdStudentDto(phdStudent);
    }

    @Override
    public List<PhdStudentDto> getAllPhdStudent() {
        List<PhdStudent> phdStudents = phdStudentRepository.findAll();

        phdStudents.forEach( phdStudent -> {
            if(phdStudent.getLaboId() != null) {
                Labo labo = laboServiceClient.getLaboById(phdStudent.getLaboId());
                phdStudent.setLabo(labo);
            }

            if(phdStudent.getTeamId() != null) {
                Team team = laboServiceClient.getTeamById(phdStudent.getTeamId());
                phdStudent.setTeam(team);
            }

        });

        return phdStudents.stream().map((phdStudent)-> PhdStudentMapper.mapToPhdStudentDto(phdStudent))
                .collect(Collectors.toList());
    }

    @Override
    public PhdStudentDto updatePhdStudent(Long id, PhdStudentDto updatedPhdStudent) {
        PhdStudent phdStudent = phdStudentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PhdStudent is not exits with given id "+id));
        if(updatedPhdStudent.getFirstname()!= null) phdStudent.setFirstname(updatedPhdStudent.getFirstname());
        if(updatedPhdStudent.getLastname()!= null) phdStudent.setLastname(updatedPhdStudent.getLastname());
        if(updatedPhdStudent.getPhone()!= null) phdStudent.setPhone(updatedPhdStudent.getPhone());
        if(updatedPhdStudent.getEmail()!= null) phdStudent.setEmail(updatedPhdStudent.getEmail());

        PhdStudent savedPhdStudent = phdStudentRepository.save(phdStudent);
        return PhdStudentMapper.mapToPhdStudentDto(savedPhdStudent);

    }

    @Override
    public void deletePhdStudent(Long id) {
        PhdStudent phdStudent = phdStudentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PhdStudent is not exits with given id "+id));
        phdStudentRepository.deleteById(id);

    }
}
