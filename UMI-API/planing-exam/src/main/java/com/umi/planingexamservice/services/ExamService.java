package com.umi.planingexamservice.services;

import com.umi.planingexamservice.dtos.ExamDto;

import java.util.List;

public interface ExamService {
    ExamDto createExam(ExamDto examDto);
    ExamDto getExamById(Long examId);
    List<ExamDto> getAllExams();
    ExamDto updateExam(Long examId, ExamDto examUpdated);
    void deleteExam(Long examId);
}
