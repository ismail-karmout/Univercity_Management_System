package com.umi.studentservice.controller;

import com.umi.studentservice.dto.StudentDto;
import com.umi.studentservice.entity.Student;
import com.umi.studentservice.repository.StudentRepository;
import com.umi.studentservice.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class StudentRestController {
    private StudentService studentService;
    // Add student Rest Api
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PostMapping("/upload-students")
    public ResponseEntity<?> uploadStudentsData(@RequestParam("file")MultipartFile file){
        System.out.println("###################################################");
        this.studentService.saveStudentsToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Students data uploaded and saved to database successfully"));
    }

    // Get student Rest Api
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }
    // Get all students Rest Api
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/export-to-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Students_Information.xlsx";
        response.setHeader(headerKey, headerValue);
        studentService.exportStudentToExcel(response);

    }

    // Update student Rest Api
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto updateStudent){
        StudentDto  studentDto = studentService.updateStudent(studentId, updateStudent);
        return ResponseEntity.ok(studentDto);
    }
    // Delete student Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}
