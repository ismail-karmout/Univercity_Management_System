package com.umi.planingexamservice.services;

import com.umi.planingexamservice.dtos.PlaningExamDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlaningExamService {
    PlaningExamDto createPlaningExam(PlaningExamDto planingExamDto);
    PlaningExamDto getPlaningExamById(Long planingExamId);
    List<PlaningExamDto> getAllPlaningExam();
    PlaningExamDto updatePlaningExam(Long planingExamId, PlaningExamDto updatedPlaningExam);
    void deletePlaningExam(Long planingExamId);

    void saveFile(MultipartFile file) throws IOException;
}
