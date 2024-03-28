package com.umi.planingexamservice.mappers;

import com.umi.planingexamservice.dtos.PlaningExamDto;
import com.umi.planingexamservice.entities.PlaningExam;

public class PlaningExamMapper {
    public static PlaningExamDto mapToPlaningExamDto(PlaningExam planingExam){
        return new PlaningExamDto(
                planingExam.getId(),
                planingExam.getAvis(),
                planingExam.getPlaning(),
                planingExam.getSemestreId(),
                planingExam.getSemestre(),
                planingExam.getExams(),
                planingExam.getCreated_at(),
                planingExam.getUpdated_at()
        );
    }

    public static PlaningExam mapToPlaningExam(PlaningExamDto planingExamDto){
        return new PlaningExam(
                planingExamDto.getId(),
                planingExamDto.getAvis(),
                planingExamDto.getPlaning(),
                planingExamDto.getSemestreId(),
                planingExamDto.getSemestre(),
                planingExamDto.getExam(),
                planingExamDto.getCreated_at(),
                planingExamDto.getUpdated_at()
        );
    }
}
