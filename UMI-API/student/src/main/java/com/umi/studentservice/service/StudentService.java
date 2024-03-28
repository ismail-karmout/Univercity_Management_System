package com.umi.studentservice.service;

import com.umi.studentservice.dto.StudentDto;
import com.umi.studentservice.entity.Student;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long studentId, StudentDto updatedStudent);
    void deleteStudent(Long studentId);
    void saveStudentsToDatabase(MultipartFile file);
    List<Student> exportStudentToExcel(HttpServletResponse response) throws IOException;
}
