package com.umi.planingexamservice.mappers;

import com.umi.planingexamservice.dtos.ExamDto;
import com.umi.planingexamservice.entities.Exam;

public class ExamMapper {
    public static ExamDto mapToExamDto(Exam exam){
        return new ExamDto(
                exam.getId(),
                exam.getName(),
                exam.getExam(),
                exam.getPlaningExam(),
                exam.getCreated_at(),
                exam.getUpdated_at()
        );
    }

    public static Exam mapToExam(ExamDto examDto){
        return new Exam(
                examDto.getId(),
                examDto.getName(),
                examDto.getExam(),
                examDto.getPlaningExam(),
                examDto.getCreated_at(),
                examDto.getUpdated_at()
        );
    }
}
