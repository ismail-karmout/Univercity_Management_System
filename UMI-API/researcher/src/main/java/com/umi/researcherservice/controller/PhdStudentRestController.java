package com.umi.researcherservice.controller;

import com.umi.researcherservice.dto.PhdStudentDto;
import com.umi.researcherservice.service.PhdStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phdStudents")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PhdStudentRestController {
    private PhdStudentService phdStudentService;
    @PostMapping
    ResponseEntity<PhdStudentDto> createPhdStudent(@RequestBody PhdStudentDto phdStudentDto){
        PhdStudentDto createdPhdStudent = phdStudentService.createPhdStudent(phdStudentDto);
        return new ResponseEntity<>(createdPhdStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<PhdStudentDto> getPhdStudentById(@PathVariable("id") Long phdStudentId){
        PhdStudentDto phdStudentDto = phdStudentService.getPhdStudentById(phdStudentId);
        return ResponseEntity.ok(phdStudentDto);
    }

    @GetMapping
    ResponseEntity<List<PhdStudentDto>> getAllPhdStudent(){
        List<PhdStudentDto> phdStudents = phdStudentService.getAllPhdStudent();
        return ResponseEntity.ok(phdStudents);
    }

    @PutMapping("{id}")
    ResponseEntity<PhdStudentDto> updatePhdStudent(@PathVariable("id") Long id, @RequestBody PhdStudentDto updatedPhdStudent){
        PhdStudentDto phdStudentUpdated = phdStudentService.updatePhdStudent(id, updatedPhdStudent);
        return ResponseEntity.ok(phdStudentUpdated);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deletePhdStudent(@PathVariable("id") Long id){
        phdStudentService.deletePhdStudent(id);
        return ResponseEntity.ok("PhdStudent is deleted successfully");
    }
}
