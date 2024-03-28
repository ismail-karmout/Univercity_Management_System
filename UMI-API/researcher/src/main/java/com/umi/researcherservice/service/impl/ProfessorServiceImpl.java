package com.umi.researcherservice.service.impl;

import com.umi.researcherservice.dto.ProfessorDto;
import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.exception.ResourceNotFoundException;
import com.umi.researcherservice.feign.LaboServiceClient;
import com.umi.researcherservice.mapper.ProfessorMapper;
import com.umi.researcherservice.mapper.ProfessorMapper;
import com.umi.researcherservice.mapper.ProfessorMapper;
import com.umi.researcherservice.mapper.ProfessorMapper;
import com.umi.researcherservice.model.Labo;
import com.umi.researcherservice.model.Team;
import com.umi.researcherservice.repository.ProfessorRepository;
import com.umi.researcherservice.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;
    private LaboServiceClient laboServiceClient;

    @Override
    public ProfessorDto createProfessor(ProfessorDto professorDto) {
        Professor professor = ProfessorMapper.mapToProfessor(professorDto);
        Professor createdProfessor = professorRepository.save(professor);
        return ProfessorMapper.mapToProfessorDto(createdProfessor);
    }

    @Override
    public ProfessorDto getProfessorById(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor is not exits with given id "+id));

//        if(professor.getLaboId()!= null){
//            professor.setLabo(laboServiceClient.getLaboById(professor.getLaboId()));
//        }
        if(professor.getTeamId()!= null){
            professor.setTeam(laboServiceClient.getTeamById(professor.getTeamId()));
        }

        return ProfessorMapper.mapToProfessorDto(professor);
    }

    @Override
    public List<ProfessorDto> getAllProfessor() {
        List<Professor> professors = professorRepository.findAll();

        professors.forEach( professor -> {
//            if(professor.getLaboId() != null) {
//                Labo labo = laboServiceClient.getLaboById(professor.getLaboId());
//                professor.setLabo(labo);
//            }

            if(professor.getTeamId() != null) {
                Team team = laboServiceClient.getTeamById(professor.getTeamId());
                professor.setTeam(team);
            }

        });

        return professors.stream().map((professor)-> ProfessorMapper.mapToProfessorDto(professor))
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDto updateProfessor(Long id, ProfessorDto updatedProfessor) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor is not exits with given id "+id));
        if(updatedProfessor.getFirstname()!= null) professor.setFirstname(updatedProfessor.getFirstname());
        if(updatedProfessor.getLastname()!= null) professor.setLastname(updatedProfessor.getLastname());
        if(updatedProfessor.getPhone()!= null) professor.setPhone(updatedProfessor.getPhone());
        if(updatedProfessor.getEmail()!= null) professor.setEmail(updatedProfessor.getEmail());

        Professor savedProfessor = professorRepository.save(professor);
        return ProfessorMapper.mapToProfessorDto(savedProfessor);
    }

    @Override
    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor is not exits with given id "+id));
        professorRepository.deleteById(id);
    }
}
