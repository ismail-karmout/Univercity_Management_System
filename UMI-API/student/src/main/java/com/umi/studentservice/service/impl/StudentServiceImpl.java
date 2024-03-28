package com.umi.studentservice.service.impl;

import com.umi.studentservice.dto.StudentDto;
import com.umi.studentservice.entity.Student;
import com.umi.studentservice.exception.ResourceNotFoundException;
import com.umi.studentservice.feign.GroupServiceClient;
import com.umi.studentservice.mapper.StudentMapper;
import com.umi.studentservice.model.Group;
import com.umi.studentservice.repository.StudentRepository;
import com.umi.studentservice.service.ExcelUploadService;
import com.umi.studentservice.service.ExportExcelService;
import com.umi.studentservice.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private GroupServiceClient groupServiceClient;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exists with given id : " + studentId));

        if(student.getGroupId()!= null){
            student.setGroup(groupServiceClient.getGroupById(student.getGroupId()));
        }

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        students.forEach( student -> {
            if(student.getGroupId() != null) {
                Group group = groupServiceClient.getGroupById(student.getGroupId());
                student.setGroup(group);
            }
        });
        return students.stream().map((student)-> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not exists with given id " +studentId));

        if(updatedStudent.getFirstname() != null) student.setFirstname(updatedStudent.getFirstname());
        if(updatedStudent.getLastname() != null) student.setLastname(updatedStudent.getLastname());
        if(updatedStudent.getEmail() != null) student.setEmail(updatedStudent.getEmail());
        if(updatedStudent.getCne() != null) student.setCne(updatedStudent.getCne());
        if(updatedStudent.getCni() != null) student.setCni(updatedStudent.getCni());

        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student is not exits with given id " + studentId));
        studentRepository.deleteById(studentId);
    }

    @Override
    public void saveStudentsToDatabase(MultipartFile file){
        if(ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Student> students = ExcelUploadService.getStudentsDataFromExcel(file.getInputStream());
                this.studentRepository.saveAll(students);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    @Override
    public List<Student> exportStudentToExcel(HttpServletResponse response) throws IOException {
        List<Student> students = studentRepository.findAll();
        ExportExcelService exportUtils = new ExportExcelService(students);
        exportUtils.exportDataToExcel(response);
        return students;
    }


}
