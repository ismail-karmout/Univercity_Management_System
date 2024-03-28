package com.umi.planingexamservice.controllers;

import com.umi.planingexamservice.dtos.ExamDto;
import com.umi.planingexamservice.services.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@AllArgsConstructor
public class ExamRestController {
    private ExamService examService;
    @PostMapping
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamDto examDto){
        ExamDto exam = examService.createExam(examDto);
        return new ResponseEntity<>(exam, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExamDto> getExamById(@PathVariable("id") Long examId){
        ExamDto exam = examService.getExamById(examId);
        return ResponseEntity.ok(exam);
    }

    @GetMapping
    public ResponseEntity<List<ExamDto>> getAllExam(){
        List<ExamDto> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExamDto> updateExam(@PathVariable("id") Long examId, @RequestBody ExamDto updatedExam){
        ExamDto examDto = examService.updateExam(examId, updatedExam);
        return  ResponseEntity.ok(examDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExam(@PathVariable("id") Long examId){
        examService.deleteExam(examId);
        return ResponseEntity.ok("Exam deleted successfully");
    }

}
