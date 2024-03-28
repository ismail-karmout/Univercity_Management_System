package com.umi.researcherservice.service;

import com.umi.researcherservice.dto.ProfessorDto;

import java.util.List;

public interface ProfessorService {
    ProfessorDto createProfessor(ProfessorDto ProfessorDto);
    ProfessorDto getProfessorById(Long id);
    List<ProfessorDto> getAllProfessor();
    ProfessorDto updateProfessor(Long id, ProfessorDto updatedProfessor);
    void deleteProfessor(Long id);
}
