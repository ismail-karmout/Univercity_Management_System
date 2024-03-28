package com.umi.planingexamservice.services.impl;

import com.umi.planingexamservice.dtos.ExamDto;
import com.umi.planingexamservice.entities.Exam;
import com.umi.planingexamservice.exceptions.ResourceNotFoundException;
import com.umi.planingexamservice.mappers.ExamMapper;
import com.umi.planingexamservice.repositories.ExamRepository;
import com.umi.planingexamservice.services.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {
    private ExamRepository examRepository;
    @Override
    public ExamDto createExam(ExamDto examDto) {
        Exam exam = ExamMapper.mapToExam(examDto);
        Exam savedExam = examRepository.save(exam);
        return ExamMapper.mapToExamDto(savedExam);
    }

    @Override
    public ExamDto getExamById(Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(()-> new ResourceNotFoundException("Exam is not exists with given id " +examId));
        return ExamMapper.mapToExamDto(exam);
    }

    @Override
    public List<ExamDto> getAllExams() {
        List<Exam> exams = examRepository.findAll();
        return exams.stream().map((exam) -> ExamMapper.mapToExamDto(exam))
                .collect(Collectors.toList());
    }

    @Override
    public ExamDto updateExam(Long examId, ExamDto examUpdated) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(()-> new ResourceNotFoundException("Exam is not exits with given id " +examId));
        if(examUpdated.getName() != null) exam.setName(examUpdated.getName());
        if(examUpdated.getExam() != null) exam.setExam(examUpdated.getExam());
        if(examUpdated.getPlaningExam() != null) exam.setPlaningExam(exam.getPlaningExam());

        Exam updatedExamObj = examRepository.save(exam);

        return ExamMapper.mapToExamDto(updatedExamObj);
    }

    @Override
    public void deleteExam(Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(()-> new ResourceNotFoundException("Exam is not exists with given id " +examId));
        examRepository.deleteById(examId);
    }
}
