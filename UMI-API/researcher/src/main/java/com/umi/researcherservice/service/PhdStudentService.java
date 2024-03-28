package com.umi.researcherservice.service;

import com.umi.researcherservice.dto.PhdStudentDto;

import java.util.List;

public interface PhdStudentService {
    PhdStudentDto createPhdStudent(PhdStudentDto phdStudentDto);
    PhdStudentDto getPhdStudentById(Long id);
    List<PhdStudentDto> getAllPhdStudent();
    PhdStudentDto updatePhdStudent(Long id, PhdStudentDto updatedPhdStudent);
    void deletePhdStudent(Long id);
}
