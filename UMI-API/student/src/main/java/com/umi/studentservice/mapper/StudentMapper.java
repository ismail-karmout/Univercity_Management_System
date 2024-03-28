package com.umi.studentservice.mapper;

import com.umi.studentservice.dto.StudentDto;
import com.umi.studentservice.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getCne(),
                student.getCni(),
                student.getGroupId(),
                student.getGroup(),
                student.getCreated_at(),
                student.getUpdated_at()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstname(),
                studentDto.getLastname(),
                studentDto.getEmail(),
                studentDto.getCne(),
                studentDto.getCni(),
                studentDto.getGroupId(),
                studentDto.getGroup(),
                studentDto.getCreated_at(),
                studentDto.getUpdated_at()
        );
    }
}
